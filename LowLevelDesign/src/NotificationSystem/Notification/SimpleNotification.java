package NotificationSystem.Notification;

public class SimpleNotification implements INotification{

    private String text;

    public SimpleNotification(String Text)
    {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
