package BookMyShow.Models;

public class User {
    int id;
    String Name;
    private static volatile int  nextId = 1;

    public User(String Name )
    {
        this.Name = Name;
        this.id = ++nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
