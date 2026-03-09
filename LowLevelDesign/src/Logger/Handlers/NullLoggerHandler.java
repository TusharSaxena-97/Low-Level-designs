package Logger.Handlers;

import Logger.Entities.FileLogOutput;
import Logger.Entities.Message;

public class NullLoggerHandler extends ILoggerHandler{
    @Override
    public void Log(Message message) {
        // to Avoid NPE
        return;
    }
}
