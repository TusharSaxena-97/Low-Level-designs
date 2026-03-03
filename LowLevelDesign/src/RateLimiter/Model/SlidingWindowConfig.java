package RateLimiter.Model;

public class SlidingWindowConfig extends Config{

    public SlidingWindowConfig(long windowSize , long maxRequets)
    {
        this.maxRequests = maxRequets;
        this.windowSize = windowSize;
    }
}
