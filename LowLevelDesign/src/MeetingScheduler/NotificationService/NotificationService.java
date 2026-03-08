package MeetingScheduler.NotificationService;

import MeetingScheduler.Entities.Meeting;
import MeetingScheduler.Entities.User;

import java.util.List;

public class NotificationService implements IObserver {
    @Override
    public void sendNotification(Meeting meeting , List<User> users) {
        // Send out Notifications to all the invitees.
    }
}
