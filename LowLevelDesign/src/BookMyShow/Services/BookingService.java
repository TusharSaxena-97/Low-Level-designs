package BookMyShow.Services;

import BookMyShow.Models.Seat;
import BookMyShow.Models.Show;
import BookMyShow.Models.User;
import BookMyShow.Repositories.BookingFactory;

import java.util.*;

public abstract class BookingService{
    protected BookingFactory bookingFactory;
    protected PaymentService paymentService;
    protected User user;
    protected LockManager lockManager;
    protected List<Seat> seats;
    public abstract boolean createBooking(Show show , List<Seat> seat,User user);
}
