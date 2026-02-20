package NotificationSystem.Subscriber;

import NotificationSystem.Notification.INotification;
import NotificationSystem.NotificationStrategy.*;

import java.util.*;

public class NotificationEngine extends Subscriber{
    Publisher publisher;
    List<INotificationStrategy> NotificationStrategies = new ArrayList<>();

    NotificationEngine(Publisher publisher)
    {
        this.publisher = publisher;
    }

    public NotificationEngine()
    {

    }

    public void setPublisher(Publisher publisher )
    {
        this.publisher = publisher;
    }

    @Override
    public void sendNotification(INotification notifications)
    {
        for( INotificationStrategy nfs : NotificationStrategies )
            nfs.sendNotification( publisher.notification );
    }

    public void addNotificationStrategy(INotificationStrategy notificationStrategy)
    {
        NotificationStrategies.add(notificationStrategy);
    }

}
