package SplitWise.Repositories;

import SplitWise.Entities.Group;
import java.util.*;

public class GroupRepository {
    Set<Group> groups = new HashSet<>();

    public void addGroup( Group group )
    {
        groups.add( group );
    }

    public void deleteGroup( Group group )
    {
        groups.remove( group );
    }

    public Group getById( int groupId )
    {
        return groups.stream().filter( o -> o.getGroupId() == groupId ).findAny().get();
    }
}
