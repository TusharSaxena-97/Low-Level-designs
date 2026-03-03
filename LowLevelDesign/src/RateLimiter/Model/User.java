package RateLimiter.Model;

public class User {
    private static long nextId = 1;
    private String Name;
    private long id;
    private UserClass userclass;
    public User(String Name , UserClass userclass)
    {
        this.Name = Name;
        this.id =nextId++;
        this.userclass = userclass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserClass getUserclass() {
        return userclass;
    }

    public void setUserclass(UserClass userclass) {
        this.userclass = userclass;
    }
}
