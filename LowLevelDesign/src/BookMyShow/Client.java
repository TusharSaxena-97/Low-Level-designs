package BookMyShow;

import BookMyShow.Factories.SeatFactory;
import BookMyShow.Models.*;
import BookMyShow.Services.*;


import java.time.LocalDateTime;
import java.util.*;


public class Client {

    public static void main(String args[]) throws Exception
    {
        App startApp = new App("Tushar");
        startApp.run();
    }
}

class App{
    User user;
    BookingService bookingService;
    PaymentService paymentService;
    ShowService showService;

    City city1;
    Seat s2,s3;
    App(String name)
    {
        user = new User(name);
        paymentService = new PaymentServiceImpl();
        bookingService = new BookingServiceImpl( paymentService );

        city1 = new City("Pune");
        City city2 = new City("Delhi");

        Seat s1 = SeatFactory.createSeat(SeatType.regular);
        s2 = SeatFactory.createSeat(SeatType.regular);
        s3 = SeatFactory.createSeat(SeatType.regular);
        Seat s4 = SeatFactory.createSeat(SeatType.regular);
        Seat s5 = SeatFactory.createSeat(SeatType.regular);
        Seat s6 = SeatFactory.createSeat(SeatType.recliner);
        Seat s7 = SeatFactory.createSeat(SeatType.recliner);
        Seat s8 = SeatFactory.createSeat(SeatType.recliner);
        List<Seat> seatSet1 = Arrays.asList( new Seat[]{ s1,s2,s6,s7 });
        List<Seat> seatSet2 = Arrays.asList( new Seat[]{ s3,s5,s4,s8 });

        Screen screen1 = new Screen( seatSet1 );
        Screen screen2 = new Screen( seatSet2 );

        Cinema hall1 = new Cinema(city1 , new ArrayList<>(Arrays.asList( new Screen[]{ screen1 , screen2 } ))  , "PVR");

        Show show1 = new Show( new Movie("tarzan") , hall1 , screen1 , city1 , LocalDateTime.now() , LocalDateTime.now().minusHours(-2) );
        Show show2 = new Show( new Movie("Interstellar") , hall1 , screen2 , city1 , LocalDateTime.now().minusHours(-3) , LocalDateTime.now().minusHours(-6) );

        showService = new ShowServiceImpl(Arrays.asList(new Show[]{ show1 , show2}));
    }

    public void run() throws Exception
    {
        List<Show> shows = showService.getShowByCity( city1 );
        displayShow( shows );
        showService.getFreeSeats( shows.get(1) );

        Thread.sleep(1000);

        boolean isBooked = bookingService.createBooking( shows.get(1) , Arrays.asList( new Seat[]{s2 , s3} ) ,  user );
        if( !isBooked )
            System.out.println( "Your seats are being booked by some other user. Please try again later");
        else {
            System.out.println("Successfully Booked");
        }
    }

    public void displayShow( List<Show> shows )
    {
        System.out.println(shows);
    }
}
