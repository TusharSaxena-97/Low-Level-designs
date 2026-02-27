package BookMyShow.Factories;

import BookMyShow.Models.BookingStatus;
import BookMyShow.Models.Seat;

public class ReclinerSeat extends Seat {

    private static volatile int nextId = 1;

    @Override
    public String getType() {
        return null;
    }

    public ReclinerSeat(double price) {
        this.price = price;
        this.number = "S" + nextId++;
        this.status = BookingStatus.notBooked;
    }
}
