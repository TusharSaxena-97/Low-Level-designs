package RateLimiter.Factories;

import RateLimiter.Model.SlidingWindowConfig;
import RateLimiter.Model.TokenBucketConfig;
import RateLimiter.main.RateLimiter;
import RateLimiter.main.SlidingWindowLog;
import RateLimiter.main.TokenBucket;
import RateLimiter.Model.UserClass;

public class RateLimiterFactory {

    public static RateLimiter createRateLimiter( UserClass userClass, long windowSize, long maxRequests )
    {
        if( userClass.equals( UserClass.Regular ) )
            return new TokenBucket( new TokenBucketConfig( windowSize , maxRequests) );
        else if( userClass.equals( UserClass.Premium ))
            return new SlidingWindowLog( new SlidingWindowConfig( windowSize , maxRequests) );
        else System.out.println("No Rate Limiter Configured for this User Class");

        return null;
    }

}
