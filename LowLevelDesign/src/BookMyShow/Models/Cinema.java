package BookMyShow.Models;
import java.util.*;

public class Cinema {
    private static volatile int nextId = 101;
    int id;
    City city;
    String cinemaName;
    List<Screen> screens;

    public Cinema(City city,ArrayList<Screen> screens, String cinemaName) {
        this.id = ++nextId;
        this.city = city;
        this.screens = screens;
        this.cinemaName = cinemaName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
