package RateLimiter.Services;

import RateLimiter.Factories.RateLimiterFactory;
import RateLimiter.Model.User;
import RateLimiter.Model.UserClass;
import RateLimiter.main.RateLimiter;
import RateLimiter.main.RateLimterClass;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterService {
    Map<UserClass,RateLimiter> map = new ConcurrentHashMap<>();
    RateLimiterFactory rateLimiterFactory;

    public RateLimiterService(){
        rateLimiterFactory = new RateLimiterFactory();
        // Map Initalisation this can be done via the application a well. using a setter
        for( UserClass userClass : UserClass.values())
            setConfig(userClass , 10 ,10 );
    }

    public boolean canAllow(User user)
    {
        UserClass userClass = user.getUserclass();
        if( map.containsKey(userClass ) )
            return map.get( userClass ).canAllow(user);
        else
            System.out.println("New UserClass - RateLimiter Type not Configured");
        return false;
    }

    public void setConfig( UserClass userClass , long windowSize, long maxRequests)
    {
        if( userClass.equals(UserClass.Regular))
            map.put( UserClass.Premium , rateLimiterFactory.createRateLimiter( UserClass.Regular , windowSize , maxRequests ));
        if( userClass.equals(UserClass.Premium))
            map.put( UserClass.Regular , rateLimiterFactory.createRateLimiter( UserClass.Premium, windowSize , maxRequests ));
    }
}
