package Logger.Handlers;

import Logger.Entities.Message;
import Logger.Entities.MessageStatus;

public class InfoHandler extends ILoggerHandler{
    public InfoHandler(ILoggerHandler next)
    {
        this.nextHandler = next;
    }
    @Override
    public void Log(Message message) {
        if( message.getMessageStatus().equals(MessageStatus.Info))
            logDestination.Append(message);
        else nextHandler.Log(message);
    }
}
