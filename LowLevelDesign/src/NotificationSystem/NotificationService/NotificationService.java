package NotificationSystem.NotificationService;

import NotificationSystem.Notification.INotification;
import NotificationSystem.NotificationStrategy.INotificationStrategy;
import NotificationSystem.Subscriber.NotificationEngine;
import NotificationSystem.Subscriber.NotificationPublisher;
import NotificationSystem.Subscriber.Publisher;

import java.util.*;

public class NotificationService {
    private static volatile NotificationService instance;
    private Publisher NotificationPublisher;
    List<INotification> notificationList = new ArrayList<>();

    private NotificationService(){
        this.NotificationPublisher = new NotificationPublisher();
    }

    public static NotificationService getInstance()
    {
        if( instance == null )
        {
            synchronized ( NotificationService.class ){
                if( instance == null )
                    instance = new NotificationService();
            }
        }
        return instance;
    }

    public void sendNotification(INotification notification)
    {
        notificationList.add(notification);
        NotificationPublisher.sendNotification(notification);
    }

    public void addNotificationEngine(NotificationEngine NotificationEngine)
    {
        NotificationEngine.setPublisher(instance.NotificationPublisher);
        instance.NotificationPublisher.Subscribe( NotificationEngine );
    }
}
