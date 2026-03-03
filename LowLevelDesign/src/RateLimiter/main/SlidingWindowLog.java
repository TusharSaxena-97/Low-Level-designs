package RateLimiter.main;

import RateLimiter.Model.Config;
import RateLimiter.Model.User;

import java.util.*;
import java.util.concurrent.*;

public class SlidingWindowLog extends RateLimiter{

    // UserIds vs their Requests
    Map<Long,Queue> map = new ConcurrentHashMap<>();
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public SlidingWindowLog( Config config)
    {
        this.config = config;

        long refreshRate =(long)( 10000 * (double) ( (double)config.windowSize / (double)config.maxRequests ));
        executor.scheduleWithFixedDelay( this::refershQueue , refreshRate ,refreshRate , TimeUnit.MILLISECONDS );
    }

    private void refershQueue()
    {
        Long now = System.currentTimeMillis();
        for( Queue<Long> value : map.values() )
            emptyQueue( now, value );
    }

    @Override
    public boolean canAllow(User user) {
        long now = System.currentTimeMillis();
        // This ensures 'q' is always the same instance for this user
        Queue<Long> q = map.computeIfAbsent(user.getId(), k -> new ConcurrentLinkedQueue<>());

        if( q.size() >= config.maxRequests )
            emptyQueue( now , q );

        if( q.size() >= config.maxRequests )
            return false;

        if( q.size() == 0 ) map.put( user.getId() , q );
        addRequest( q , now );

        return true;
    }

    public void emptyQueue(long time , Queue<Long> q)
    {
        // synchronization for the case when a single user sends multiple requests simultaneously
        synchronized( q ){
            while( !q.isEmpty() && q.peek() < time - (1000) * config.windowSize )
                q.poll();
        }
    }

    public void addRequest(Queue<Long> q , Long time )
    {
        synchronized (q){
            q.add( time );
        }
    }
}
