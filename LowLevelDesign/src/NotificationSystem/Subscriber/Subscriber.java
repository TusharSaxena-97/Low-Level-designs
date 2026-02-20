package NotificationSystem.Subscriber;
import NotificationSystem.Notification.INotification;

public abstract class Subscriber{
        private String Name;
        public abstract void sendNotification( INotification notifications);
}
