package Logger.Entities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MessageRepository {
    private List<Message> messages = new ArrayList<>();

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
