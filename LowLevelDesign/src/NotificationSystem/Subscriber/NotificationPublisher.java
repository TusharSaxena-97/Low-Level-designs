package NotificationSystem.Subscriber;

import java.util.*;

public class NotificationPublisher extends Publisher{

    public NotificationPublisher()
    {
        subscribers.add( new NotificationEngine(this));
    }

    @Override
    public void publishToAll() {
        for(Subscriber sub : this.subscribers )
            sub.sendNotification( notification );
    }
}
