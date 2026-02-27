package BookMyShow.Repositories;

import BookMyShow.Models.*;

import java.util.*;

public class BookingFactory{
    public Booking createBooking(User user, Show show, List<Seat> seat, Double totalCost){
        System.out.println("New Booking created ");
        return new Booking( user,  show, seat,  totalCost);

    }
}
