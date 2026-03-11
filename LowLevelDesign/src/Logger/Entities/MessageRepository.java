package Logger.Entities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MessageRepository {
    public static MessageRepository instance = new MessageRepository();
    private List<Message> messages = new ArrayList<>();

    public static MessageRepository getInstance()
    {
        return instance;
    }
    public void addMessage(Message message)
    {
        messages.add( message );
    }

    public Message createAddMessage(String txt , MessageStatus status)
    {
        Message message = new Message(txt , status);
        addMessage( message );

        return message;
    }
}
