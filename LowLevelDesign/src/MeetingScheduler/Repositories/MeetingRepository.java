package MeetingScheduler.Repositories;

import MeetingScheduler.Entities.Meeting;
import MeetingScheduler.Entities.User;
import MeetingScheduler.NotificationService.IObservable;
import MeetingScheduler.NotificationService.NotificationService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MeetingRepository implements IObservable {
    private static MeetingRepository instance = new MeetingRepository();
    NotificationService notificationService;
    List<Meeting> meetingList = new ArrayList<>();

    private MeetingRepository()
    {
        notificationService = new NotificationService();
    }

    public static MeetingRepository getInstance()
    {
        return instance;
    }
    public List<Meeting> getAllMeetings( )
    {
        return meetingList;
    }

    public List<Meeting> getMeetingListByRoom(int Id) {
        return meetingList.stream().filter( o -> o.getRoom().getId() == Id ).collect(Collectors.toList());
    }

    public List<Meeting> getMeetingListByRoom(LocalDate date) {
        return meetingList.stream().filter( o -> o.getDate().equals(date) ).collect(Collectors.toList());
    }

    public boolean addMeeting( Meeting meeting )
    {
        meetingList.add(meeting);
        Update(meeting , meeting.getInvitee() );
        return true;
    }

    @Override
    public void Update(Meeting meeting , List<User> users) {
        notificationService.sendNotification(meeting , users);
    }
}
