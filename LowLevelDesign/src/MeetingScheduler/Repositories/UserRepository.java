package MeetingScheduler.Repositories;

import MeetingScheduler.Entities.User;
import java.util.*;

public class UserRepository {
    List<User> users;

    public void addUser( User user ) {
        users.add(user);
    }
}
