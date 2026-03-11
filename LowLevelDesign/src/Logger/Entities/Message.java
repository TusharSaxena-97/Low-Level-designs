package Logger.Entities;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Message implements Comparable<Message>{
    private static AtomicLong nextId = new AtomicLong(1);
    private long id;
    private LocalDateTime timeStamp;
    private MessageStatus messageStatus;
    private String text;

    public Message(String text , MessageStatus messageStatus )
    {
        this.text = text;
        this.messageStatus = messageStatus;
        this.timeStamp = LocalDateTime.now();
        this.id = nextId.getAndIncrement();
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    @Override
    public String toString()
    {

        return this.timeStamp.toString() +"  [ " + this.messageStatus + " ]  " + this.text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Message o) {
        return Math.toIntExact(this.getId() - o.getId());
    }
}
