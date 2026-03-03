package RateLimiter.Model;

public class TokenBucketConfig extends Config{
    public long refillRate;

    public TokenBucketConfig(long windowSize , long maxRequets)
    {
        this.maxRequests = maxRequets;
        this.windowSize = windowSize;
        refillRate = windowSize / maxRequets;
    }

}
