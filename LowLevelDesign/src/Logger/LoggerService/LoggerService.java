package Logger.LoggerService;

import Logger.Entities.*;
import Logger.Handlers.*;
import NotificationSystem.Subscriber.Logger;

public class LoggerService {
    private static volatile LoggerService instance;
    ILoggerHandler handler;
    MessageRepository messageRepository;
    private LoggerService(String FilePath)
    {
        ILoggerHandler.logDestination = new FileLogOutput(FilePath);
        messageRepository = new MessageRepository();
        handler = new InfoHandler(new WarningHandler(new ErrorHandler(new NullLoggerHandler()) ) );
    }
    public static LoggerService getinstance(String FilePath)
    {
        if( instance == null )
        {
            synchronized(LoggerService.class)
            {
                if( instance == null)
                    instance = new LoggerService(FilePath);
            }
        }
        return instance;
    }

    public static LoggerService getinstance( )
    {
        if(instance == null )
            System.out.println("FilePath not yet set - up");
        return instance;
    }

    public void Info(String text){
        Log( text , MessageStatus.Info);
    }

    public void Error(String text){
        Log( text , MessageStatus.Error);
    }

    public void Warn(String text){
        Log( text , MessageStatus.Warning);
    }

    private void Log(String text , MessageStatus status)
    {
        Message message = messageRepository.createAddMessage(text,status);
        handler.Log(message);
    }

    public void setFilePath(String FilePath)
    {
        ILoggerHandler.logDestination = new FileLogOutput(FilePath);
    }
}
