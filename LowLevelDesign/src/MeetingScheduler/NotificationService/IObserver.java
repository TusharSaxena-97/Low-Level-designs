package MeetingScheduler.NotificationService;

import MeetingScheduler.Entities.Meeting;
import MeetingScheduler.Entities.User;

import java.util.List;

public interface IObserver {
    void sendNotification(Meeting meeting , List<User> user);
}
