package NotificationSystem.Notification;

import java.time.Instant;
import java.util.Date;

public class TimeStampNotification extends INotificationDecorator{

    public TimeStampNotification(INotification notification)
    {
        this.notification = notification;
    }

    @Override
    public String getText() {
        return notification.getText() + Date.from(Instant.now());
    }
}
