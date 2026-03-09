package Logger.Handlers;

import Logger.Entities.Message;
import Logger.Entities.MessageStatus;

public class WarningHandler extends ILoggerHandler{

    public WarningHandler(ILoggerHandler next)
    {
        this.nextHandler = next;
    }
    @Override
    public void Log(Message message) {
        if(message.getMessageStatus().equals(MessageStatus.Warning))
            logDestination.Append(message);
        else nextHandler.Log(message);
    }
}
