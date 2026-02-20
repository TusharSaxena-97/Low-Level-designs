package NotificationSystem.Subscriber;

import NotificationSystem.Notification.INotification;

public class Logger extends Subscriber{

    @Override
    public void sendNotification(INotification notifications) {
        System.out.println("Logging into file......");
        System.out.println(notifications.getText());
    }
}
