package NotificationSystem.NotificationStrategy;

import NotificationSystem.Notification.INotification;

public class SmsNotification implements INotificationStrategy{

    public String phoneNumber;

    public SmsNotification(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendNotification(INotification notification) {
        System.out.println("Sending Notification via SMS => "+ notification.getText() );
    }

}
