package MeetingScheduler.Entities;

public class User {
    private static int nextId = 1;
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.id = ++nextId;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
