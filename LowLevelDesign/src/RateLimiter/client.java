package RateLimiter;

import RateLimiter.Model.User;
import RateLimiter.Model.UserClass;
import RateLimiter.Services.RateLimiterService;

public class client {

    public static void main(String args[])
    {
        Application app = new Application();
        User user1 = new User("Admin", UserClass.Regular);
        User user2 = new User("Tushar", UserClass.Premium);

        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );
        app.sendRequest( user1 );

        app.sendRequest( user2 );
        app.sendRequest( user2 );
        app.sendRequest( user2 );
        app.sendRequest( user2 );
        app.sendRequest( user2 );
        app.sendRequest( user2 );
        app.sendRequest( user2 );
        app.sendRequest( user2 );
        app.sendRequest( user2 );
        app.sendRequest( user2 );
        app.sendRequest( user2 );
    }
}

class Application{
    private RateLimiterService rateLimiterService;

    public Application()
    {
        rateLimiterService = new RateLimiterService();
        rateLimiterService.setConfig( UserClass.Premium , 10 , 20 );
    }
    public void sendRequest( User user )
    {
        if( !rateLimiterService.canAllow( user ) ) System.out.println("Status 429");
        else System.out.println("Staus: 200");
    }
}
