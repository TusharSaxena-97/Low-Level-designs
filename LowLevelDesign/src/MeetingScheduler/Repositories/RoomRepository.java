package MeetingScheduler.Repositories;

import MeetingScheduler.Entities.Room;

import java.util.*;

public class RoomRepository {
    private static RoomRepository instance = new RoomRepository();
    List<Room> rooms = new ArrayList<>();

    private RoomRepository()
    {}

    public static RoomRepository  getInstance()
    {
        return instance;
    }

    public List<Room> getAllRooms()
    {
        return rooms;
    }

    public boolean addRoom( Room room )
    {
        try{
            rooms.add(room);
        }
        catch(  Exception  ex )
        {
            System.out.println(ex.getStackTrace());
            return false;
        }

        return true;
    }

    public Optional<Room> getRoomById( int id )
    {
        for( Room room : rooms )
            if( room.getId() == id )
                return Optional.ofNullable( room );

        return Optional.ofNullable(null);
    }
}
