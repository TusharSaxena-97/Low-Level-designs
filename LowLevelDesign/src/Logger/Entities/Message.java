package Logger.Entities;

import java.time.LocalDateTime;

public class Message {
    private LocalDateTime timeStamp;
    private MessageStatus messageStatus;
    private String text;

    public Message(String text , MessageStatus messageStatus )
    {
        this.text = text;
        this.messageStatus = messageStatus;
        this.timeStamp = LocalDateTime.now();
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    @Override
    public String toString() {
        return this.timeStamp.toString() +"  [ " + this.messageStatus + " ]  " + this.text;
    }
}
