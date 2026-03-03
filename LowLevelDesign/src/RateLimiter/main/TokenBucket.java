package RateLimiter.main;

import RateLimiter.Model.Config;
import RateLimiter.Model.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

public class TokenBucket extends RateLimiter{
    // Map UserId , Request Tokens currently
    Map< Long,Long> bucket = new ConcurrentHashMap<>();
    Map< Long, Long> lastRequestTime = new ConcurrentHashMap<>();

    public TokenBucket(Config config)
    {
        this.config = config;
    }

    @Override
    public boolean canAllow(User user) {
        long now = System.currentTimeMillis();
        long prev_time = lastRequestTime.getOrDefault(user.getId() , 0L );
        long tokens = bucket.computeIfAbsent(user.getId() , k -> config.maxRequests );
        long refillRate = ( config.windowSize / config.maxRequests );
        long refillTokens = ( now - prev_time ) / ( refillRate  );

        if( tokens + refillTokens == 0 )
            return false;

        bucket.put( user.getId() , Math.min( config.maxRequests , tokens + refillTokens ) - 1 );
        lastRequestTime.put( user.getId() , now );

        return true;
    }
}

