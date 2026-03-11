package Logger.LoggerService;

import Logger.Entities.*;
import Logger.Handlers.*;
import Logger.QueueService.QueueService;
import Logger.WorkerService.Worker;

public class LoggerService {
    private static volatile LoggerService instance;

    QueueService queueService;
    MessageRepository messageRepository;
    private LoggerService(String Filepath )
    {
        new Worker(Filepath);
        messageRepository = MessageRepository.getInstance();
        queueService = QueueService.getInstance();
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
        queueService.addToQueue( messageRepository.createAddMessage( text , status) );
    }
    public void setFilePath(String FilePath)
    {
        ILoggerHandler.logDestination = new FileLogOutput(FilePath);
    }
}
