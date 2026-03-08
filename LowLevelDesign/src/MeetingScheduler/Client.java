package MeetingScheduler;

import MeetingScheduler.Entities.Meeting;
import MeetingScheduler.Entities.Room;
import MeetingScheduler.Entities.User;
import MeetingScheduler.Repositories.RoomRepository;
import MeetingScheduler.Services.MeetingService;
import MeetingScheduler.Services.RoomSearchService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String args[])
    {
        MeetingScheduler ms = new MeetingScheduler();
        ms.schedule( );
    }
}

class MeetingScheduler
{
    private User admin = new User("Tushar");
    private User user1 = new User("amit");
    private User user2 = new User("Yogesh");
    private User user3 = new User("Aditya");
    MeetingService meetingService;
    RoomSearchService roomSearchService;

    RoomRepository roomRepository;
    public MeetingScheduler()
    {
        meetingService = new MeetingService();
        roomSearchService = new RoomSearchService();
        roomRepository = RoomRepository.getInstance();

        roomRepository.addRoom( new Room(4 , "Room1"));
        roomRepository.addRoom( new Room(5 , "Room2"));
        roomRepository.addRoom( new Room(8, "Room3"));
        roomRepository.addRoom( new Room(10 , "Room4"));
    }

    public Optional<Meeting> schedule()
    {
        LocalDateTime startTime = LocalDateTime.now().plus(1, TimeUnit.HOURS.toChronoUnit());
        LocalDateTime endTime = LocalDateTime.now().plus(2, TimeUnit.HOURS.toChronoUnit());
        LocalDate date = LocalDate.now();

        List<User> invitee = Arrays.asList( new User[]{ user1 , user2 , user3});

        List<Room> emptyRooms = roomSearchService.getEmptyRooms(LocalDate.now() , startTime , endTime , 8 );
        return meetingService.bookRoom( date , startTime , endTime , admin , invitee , "Discuss Tushar's Promotion" , emptyRooms.get( 0 ) );
    }
}