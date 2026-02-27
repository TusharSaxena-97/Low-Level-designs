package BookMyShow.Services;

import BookMyShow.Models.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

// Singleton Class
public class LockManager {
    ConcurrentMap<String,LocalDateTime> mp = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public LockManager() {
        startCleanupTask();
    }

    private void startCleanupTask() {
        scheduler.scheduleWithFixedDelay( this::clean , 1 , 1 , TimeUnit.MINUTES );
    }

    private void clean() {
        mp.entrySet().removeIf( o -> (o.getValue().isBefore(LocalDateTime.now())));
    }

    public boolean tryLock( Show show, List<Seat> seat )
    {
        LocalDateTime now_time = LocalDateTime.now();

        for( Seat s : seat ) {
            String key = Integer.toString(show.getId()) + "_" +s.getNumber();
            if(mp.containsKey(key) && mp.get(key).isAfter(now_time) )
                return false;
        }

        for( Seat s : seat ) {
            String key = Integer.toString(show.getId()) + "_" + s.getNumber();
            mp.put( key , show.getEndTime() );
        }

        return true;
    }

    public void unLock(Show show, List<Seat> seat )
    {
        for( Seat s : seat){
            String key = Integer.toString(show.getId()) + "_" + s.getNumber();
            if (mp.containsKey(key) && mp.get(key).isAfter(LocalDateTime.now()))
                mp.remove(key);
        }
    }
}

class SeatTime{
    private Set<Seat> seats;
    private LocalDateTime time;
    public SeatTime(Set<Seat> seats, LocalDateTime time) {
        this.seats = seats;
        this.time = time;
    }
    public Set<Seat> getSeats() {
        return seats;
    }
    public LocalDateTime getTime() {
        return time;
    }
}
