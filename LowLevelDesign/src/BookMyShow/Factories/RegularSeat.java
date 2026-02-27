package BookMyShow.Factories;

import BookMyShow.Models.BookingStatus;
import BookMyShow.Models.Seat;

public class RegularSeat extends Seat {
    private static volatile int nextId = 1;

    @Override
    public String getType() {
        return null;
    }

    public RegularSeat(double price) {
        this.setNumber("R" + nextId++);
        this.setPrice( price );
        this.setStatus(BookingStatus.notBooked);
    }
}
