package RateLimiter.main;

import RateLimiter.Model.Config;
import RateLimiter.Model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingFixedWindow extends RateLimiter{
    private final Map<Long,RequestTimeCount > map = new ConcurrentHashMap<>();

    public SlidingFixedWindow(Config config)
    {
        this.config = config;
    }

    @Override
    public boolean canAllow(User user) {
        long now = System.currentTimeMillis();
        RequestTimeCount prevRequestTimeCount = map.get( user.getId() );

        if( prevRequestTimeCount != null )
        {
            long prevReqCount = prevRequestTimeCount.getCount();

            if ( prevReqCount == config.maxRequests )
            {
                long prevWindow = ( prevRequestTimeCount.getRequestTime() / ( config.windowSize * 1000 ));
                long nowWindow = now / (1000 * config.windowSize);

                if( nowWindow == prevWindow ) return false;
            }
        }

        map.put(user.getId(), new RequestTimeCount( now , 1));
        return true;

    }

}

class RequestTimeCount{
    private final long RequestTime;
    private final int count;
    public RequestTimeCount(long requestTime, int count) {
        this.RequestTime = requestTime;
        this.count = count;
    }

    public long getRequestTime() {
        return RequestTime;
    }

    public int getCount() {
        return count;
    }
}
