package MeetingScheduler.NotificationService;

import MeetingScheduler.Entities.Meeting;
import MeetingScheduler.Entities.User;

import java.util.List;

public interface IObservable {
    public abstract void Update(Meeting m , List<User> users);
}
