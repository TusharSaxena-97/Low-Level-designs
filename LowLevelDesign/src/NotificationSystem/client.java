package NotificationSystem;

import NotificationSystem.Notification.INotification;
import NotificationSystem.Notification.SimpleNotification;
import NotificationSystem.Notification.TimeStampNotification;
import NotificationSystem.NotificationService.NotificationService;
import NotificationSystem.NotificationStrategy.EmailNotification;
import NotificationSystem.NotificationStrategy.SmsNotification;
import NotificationSystem.Subscriber.NotificationEngine;

import javax.management.Notification;

public class client {

    public static void main( String args[] )
    {
        NotificationService NS = NotificationService.getInstance();

        NotificationEngine ne = new NotificationEngine();
        ne.addNotificationStrategy( new EmailNotification("Tusharsaxena803@gmail.com") );
        ne.addNotificationStrategy( new SmsNotification("91-9887766554") );

        NS.addNotificationEngine(ne);


        INotification notification = new TimeStampNotification( new SimpleNotification("This is a new Notification"));
        NS.sendNotification( notification );
    }

}
