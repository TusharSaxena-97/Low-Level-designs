package NotificationSystem.Notification;

public class HeaderNotification extends INotificationDecorator{

    HeaderNotification( INotification notification )
    {
        this.notification = notification;
    }

    @Override
    public String getText() {
        return "Hey Hope You are having a good Day";
    }
}
