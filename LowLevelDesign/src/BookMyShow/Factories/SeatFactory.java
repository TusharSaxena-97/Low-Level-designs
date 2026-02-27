package BookMyShow.Factories;

import BookMyShow.Models.Seat;
import BookMyShow.Models.SeatType;

public class SeatFactory {

    public static Seat createSeat(SeatType seatType)
    {
        if( seatType.equals(SeatType.regular))
            return new RegularSeat( new Double( 100));
        else if( seatType.equals(SeatType.recliner))
            return new ReclinerSeat( new Double( 200 ));

        return null;
    }
}
