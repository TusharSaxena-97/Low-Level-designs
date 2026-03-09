package Logger.Handlers;

import Logger.Entities.FileLogOutput;
import Logger.Entities.LogDestination;
import Logger.Entities.Message;

public abstract class ILoggerHandler{
    protected ILoggerHandler nextHandler;
    public static LogDestination logDestination;
    public abstract void Log(Message message);
}
