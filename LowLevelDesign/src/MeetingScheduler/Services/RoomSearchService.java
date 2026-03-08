package MeetingScheduler.Services;

import MeetingScheduler.Entities.Meeting;
import MeetingScheduler.Entities.MeetingBuilder;
import MeetingScheduler.Entities.Room;
import MeetingScheduler.Entities.User;
import MeetingScheduler.Repositories.MeetingRepository;
import MeetingScheduler.Repositories.RoomRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RoomSearchService {
    private RoomRepository roomRepository;
    private MeetingRepository meetingRepository;
    private RoomLockManager roomLockManager;

    public RoomSearchService() {
        this.roomRepository = RoomRepository.getInstance();
        this.meetingRepository = MeetingRepository.getInstance();
        this.roomLockManager  = RoomLockManager.getInstance();
    }

    public List<Room> getEmptyRooms(LocalDate date , LocalDateTime startTime , LocalDateTime endTime, int capacity )
    {
            Predicate<Meeting> overlap =
                    m -> m.getStartTime().isBefore(endTime) &&
                            m.getEndTime().isAfter(startTime);

            // Rooms that are already booked in this time slot
            Set<Room> bookedRooms = meetingRepository.getAllMeetings()
                    .stream()
                    .filter(m -> m.getDate().equals(date))
                    .filter(overlap)
                    .map(Meeting::getRoom)
                    .collect(Collectors.toSet());

            // Return rooms that are NOT booked
            return roomRepository.getAllRooms()
                    .stream()
                    .filter(r -> r.getCapacity() >= capacity)
                    .filter(r -> !bookedRooms.contains(r))
                    .collect(Collectors.toList());
        }
}
