package MeetingScheduler.Entities;

import java.time.LocalDate;
import java.util.*;

public class Room {
    private static int nextId = 1;
    private int id;
    private int capacity;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room(int capacity, String name) {
        this.capacity = capacity;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    //  private Map<LocalDate,Meeting> map = new HashMap<>();
}
