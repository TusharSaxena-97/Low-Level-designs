package BookMyShow.Models;

import java.time.LocalDateTime;

public class Show {
    int id;
    Movie movie;
    Cinema cinema;
    Screen screen;
    City city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScree(Screen scree) {
        this.screen = screen;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Show(Movie movie, Cinema cinema, Screen scree, City city, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = nextId++;
        this.movie = movie;
        this.cinema = cinema;
        this.screen = scree;
        this.city = city;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private static volatile int nextId = 15;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
