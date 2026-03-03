package RateLimiter.main;

import RateLimiter.Model.Config;
import RateLimiter.Model.User;

public abstract class RateLimiter {
    public Config config;
    public abstract boolean canAllow(User user);
}
