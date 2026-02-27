package BookMyShow.Models;

public class City {
    private static volatile int nextId = 1;
    int id;
    String Name;

    public City( String Name)
    {
        id = ++nextId;
        this.Name = Name;
    }
}
