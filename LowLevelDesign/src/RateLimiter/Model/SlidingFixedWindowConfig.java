package RateLimiter.Model;

public class SlidingFixedWindowConfig extends Config{

    public SlidingFixedWindowConfig(long windowSize , long maxRequets)
    {
        this.maxRequests = maxRequets;
        this.windowSize = windowSize;
    }

}
