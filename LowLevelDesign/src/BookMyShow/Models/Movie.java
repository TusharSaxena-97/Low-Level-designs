package BookMyShow.Models;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Movie {
    static volatile int nextId = 1;
    int id;
    String name;
int duration;

    public Movie(String name) {
        id = ++nextId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
