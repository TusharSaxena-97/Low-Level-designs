package BookMyShow.Models;

import BookMyShow.Repositories.BookingFactory;

import java.util.*;

public class Booking {
    private User user;
    private Show show;
    private List<Seat> seat;
    Double totalCost;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Booking(User user, Show show, List<Seat> seat, Double totalCost) {
        this.user = user;
        this.show = show;
        this.seat = seat;
        this.totalCost = totalCost;
    }
}
