package BookMyShow.Services;

import BookMyShow.Models.BookingStatus;
import BookMyShow.Models.City;
import BookMyShow.Models.Seat;
import BookMyShow.Models.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowServiceImpl extends ShowService {

    public ShowServiceImpl(List<Show> shows)
    {
        this.shows = shows;
    }

    @Override
    public List<Show> getShowByCity(City city) {
        List<Show> ans = new ArrayList<>();
        for( Show show : shows )
            if( show.getCity().equals(city) )
                ans.add(show);

        return ans;
    }

    public List<Seat> getFreeSeats(int index)
    {
        return getFreeSeats( shows.get(index) );
    }

    @Override
    public List<Seat> getFreeSeats(Show show) {
        return show.getScreen().getSeats().stream().filter( o -> o.getStatus().equals(BookingStatus.booked) ).collect(Collectors.toList());
    }

}
