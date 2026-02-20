package NotificationSystem.NotificationStrategy;

import NotificationSystem.Notification.INotification;

public interface INotificationStrategy {
    public void sendNotification(INotification notification);
}
