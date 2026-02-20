package NotificationSystem.Subscriber;
import NotificationSystem.Notification.INotification;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Publisher{
    List<Subscriber> subscribers = new ArrayList<>();
    public abstract void publishToAll();
    protected INotification notification;

    public void Subscribe( Subscriber sub )
    {
        subscribers.add( sub );
    }

    public void UnSubscribe( Subscriber sub )
    {
        subscribers = subscribers.stream().filter( o -> o.equals(sub) ).collect(Collectors.toList());
    }

    public void sendNotification(INotification notification)
    {
        this.notification = notification;
        publishToAll();
    }
}
