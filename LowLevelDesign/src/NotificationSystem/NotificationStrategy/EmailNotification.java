package NotificationSystem.NotificationStrategy;

import NotificationSystem.Notification.INotification;

public class EmailNotification implements INotificationStrategy{
    public String email;

    public EmailNotification(String email)
    {
        this.email = email;
    }

    @Override
    public void sendNotification(INotification notification) {
        System.out.println("Sending Email with text => " + notification.getText() );
    }
}
