package Logger.Handlers;

import Logger.Entities.Message;
import Logger.Entities.MessageStatus;

public class ErrorHandler extends ILoggerHandler {

    public ErrorHandler(ILoggerHandler nextHandler)
    {
        this.nextHandler = nextHandler;
    }
    @Override
    public void Log(Message message) {
        if( message.getMessageStatus().equals(MessageStatus.Error))
            logDestination.Append(message);
        else nextHandler.Log(message);
    }
}
