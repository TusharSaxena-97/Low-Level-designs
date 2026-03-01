package BookMyShow.Services;

import BookMyShow.Models.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

// Singleton Class
public class LockManager {
    ConcurrentMap<String,TimeUser> mp = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public LockManager() {
        startCleanupTask();
    }

    private void startCleanupTask() {
        scheduler.scheduleWithFixedDelay( this::clean , 1 , 1 , TimeUnit.MINUTES );
    }

    private void clean() {
        mp.entrySet().removeIf( o -> (o.getValue().getTime().isBefore(LocalDateTime.now())));
    }

    public boolean tryLock(Show show, List<Seat> seats, User user) {

        LocalDateTime now = LocalDateTime.now();

        // First check if all seats are lockable
        for (Seat s : seats) {

            String key = show.getId() + "_" + s.getNumber();
            TimeUser existingLock = mp.get(key);

            if (existingLock != null) {

                // If locked by same user and not expired → allow
                if (existingLock.getUser().equals(user) &&
                        existingLock.getTime().isAfter(now)) {
                    continue;
                }

                // If locked by other user and not expired → fail
                if (existingLock.getTime().isAfter(now)) {
                    return false;
                }
            }
        }

        // Lock seats (5 minute lock example)
        LocalDateTime lockExpiry = now.plusMinutes(10);

        for (Seat s : seats) {
            String key = show.getId() + "_" + s.getNumber();
            mp.put(key, new TimeUser( lockExpiry , user));
        }

        return true;
    }

    public void unLock(Show show, List<Seat> seat )
    {
        for( Seat s : seat)
        {
            String key = Integer.toString(show.getId()) + "_" + s.getNumber();
            if (mp.containsKey(key) && mp.get(key).getTime().isAfter(LocalDateTime.now()))
                mp.remove(key);
        }
    }
}

class TimeUser{
    private final User user;
    private final LocalDateTime time;
    public TimeUser(LocalDateTime time, User user) {
        this.time = time;
        this.user = user;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public User getUser() {
        return user;
    }
}
