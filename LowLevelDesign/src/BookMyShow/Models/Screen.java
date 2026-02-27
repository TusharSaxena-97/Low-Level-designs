package BookMyShow.Models;

import java.util.*;

public class Screen {
    private static volatile int nextId;
    int id;

    public Screen(List<Seat> seats) {
        this.id = ++nextId;
        this.seats = seats;
    }
    List<Seat> seats = new ArrayList<>();

    public List<Seat> getSeats() {
        return seats;
    }
}
