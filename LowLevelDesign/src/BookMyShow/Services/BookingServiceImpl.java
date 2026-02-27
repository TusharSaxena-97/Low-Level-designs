package BookMyShow.Services;
import BookMyShow.Models.Booking;
import BookMyShow.Models.Seat;
import BookMyShow.Models.Show;
import BookMyShow.Models.User;
import BookMyShow.Repositories.BookingFactory;

import java.util.*;

public class BookingServiceImpl extends BookingService{

    public BookingServiceImpl(PaymentService paymentService)
    {
        this.paymentService = paymentService;
        this.lockManager = new LockManager();
        this.bookingFactory = new BookingFactory();
    }

    @Override
    public boolean createBooking(Show show, List<Seat> seat , User user) {
        if( lockManager.tryLock( show , seat ))
        {
            paymentService.makePayment();
            double cost = new Double(0);
            for( Seat s : seat )
                cost += s.getPrice();

            System.out.println( bookingFactory.createBooking(user , show , seat , cost ));
            return true;
        }
        return false;
    }

}
