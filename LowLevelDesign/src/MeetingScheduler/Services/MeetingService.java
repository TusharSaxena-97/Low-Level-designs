package MeetingScheduler.Services;

import MeetingScheduler.Entities.Meeting;
import MeetingScheduler.Entities.MeetingBuilder;
import MeetingScheduler.Entities.Room;
import MeetingScheduler.Entities.User;
import MeetingScheduler.Repositories.MeetingRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MeetingService {
    private  RoomLockManager roomLockManager;
    private MeetingRepository meetingRepository;

    public MeetingService()
    {
        this.roomLockManager = RoomLockManager.getInstance();
        this.meetingRepository = MeetingRepository.getInstance();
    }

    public Optional<Meeting> bookRoom(LocalDate date , LocalDateTime startTime, LocalDateTime endTime , User user , List<User> invitee, String MeetingAgenda, Room room )
    {
        MeetingBuilder mb = new MeetingBuilder();
        Meeting new_meet = null;
        try{
            if(roomLockManager.tryLock( room , date ) )
            {
                new_meet =  mb.add( room ).add(user ).add( invitee ).add(MeetingAgenda).add(startTime, endTime).add(date).build();
                meetingRepository.addMeeting(new_meet);
            }
        }
        catch(Exception e )
        {
            System.out.println(e.getStackTrace());
        }

        return Optional.ofNullable(new_meet);
    }
}
