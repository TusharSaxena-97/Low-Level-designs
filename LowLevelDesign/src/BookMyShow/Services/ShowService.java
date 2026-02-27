package BookMyShow.Services;

import BookMyShow.Models.City;
import BookMyShow.Models.Seat;
import BookMyShow.Models.Show;
import java.util.*;

public abstract class ShowService{
    List<Show> shows;
    public abstract List<Show> getShowByCity(City city);
    public abstract List<Seat> getFreeSeats(Show show);
}
