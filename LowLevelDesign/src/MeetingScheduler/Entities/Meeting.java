package MeetingScheduler.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Meeting {
    private static int nextId = 1;
    private int id;
    private Room room;
    private User createdBy;
    private List<User> invitee;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String meetingAgenda;

    public Meeting(MeetingBuilder builder) {
        this.createdBy = builder.createdBy;
        this.room = builder.room;
        this.invitee = builder.invitee;
        this.date = builder.date;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.meetingAgenda = builder.meetingAgenda;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<User> getInvitee() {
        return invitee;
    }

    public void setInvitee(List<User> invitee) {
        this.invitee = invitee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getMeetingAgenda() {
        return meetingAgenda;
    }

    public void setMeetingAgenda(String meetingAgenda) {
        this.meetingAgenda = meetingAgenda;
    }
}
