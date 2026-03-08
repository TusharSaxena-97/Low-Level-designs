package MeetingScheduler.Services;

import MeetingScheduler.Entities.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;

public class RoomLockManager {
    private static RoomLockManager instance = new RoomLockManager();
    private Map<String,LocalDateTime> map = new ConcurrentHashMap<>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public static RoomLockManager getInstance()
    {
        return instance;
    }

    private RoomLockManager()
    {
        executor.scheduleWithFixedDelay( this::CleanUp  , 10 , 10 , TimeUnit.HOURS);
    }

    public void CleanUp()
    {
        for( String key : map.keySet() )
        {
            if( map.containsKey( key ) && map.get(key).isAfter(LocalDateTime.now()) )
                map.remove( key );
        }
    }

    public boolean tryLock(Room room , LocalDate date )
    {
        String key = room.getId() + date.toString();

        if( !map.containsKey(key) )
        {
            map.put( key , LocalDateTime.now().minus(-10 , TimeUnit.SECONDS.toChronoUnit()) );
            return true;
        }
        else if( map.containsKey(key) && map.get(key).isBefore(LocalDateTime.now()) )
        {
            map.put( key , LocalDateTime.now().minus(-10, TimeUnit.SECONDS.toChronoUnit()));
            return true;
        }

        return false;
    }

    public void Unlock(Room room , Date Date)
    {
        String key = room.getId() + Date.toString();
        map.remove(key);
    }

}
