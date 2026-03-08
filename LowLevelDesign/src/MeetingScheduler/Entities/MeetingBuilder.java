package MeetingScheduler.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingBuilder {
    public Room room;
    public User createdBy;
    public List<User> invitee;
    public LocalDate date;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public String meetingAgenda;

    public MeetingBuilder add(Room room)
    {
        this.room = room;
        return this;
    }

    public MeetingBuilder add(User createdBy)
    {
        this.createdBy = createdBy;
        return this;
    }

    public MeetingBuilder add(List<User> invitee)
    {
        this.invitee = new ArrayList<>( invitee );
        return this;
    }

    public MeetingBuilder add(LocalDate date)
    {
        this.date = date;
        return this;
    }

    public MeetingBuilder add(LocalDateTime startTime, LocalDateTime endTime)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        return this;
    }

    public MeetingBuilder add(String meetingAgenda)
    {
        this.meetingAgenda = meetingAgenda;
        return this;
    }

    public Meeting build( )
    {
        return new Meeting( this );
    }
}
