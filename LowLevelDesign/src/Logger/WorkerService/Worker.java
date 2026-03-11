package Logger.WorkerService;

import Logger.Entities.FileLogOutput;
import Logger.Entities.Message;
import Logger.Handlers.*;
import Logger.QueueService.QueueService;

import java.util.concurrent.*;
import java.util.*;

public class Worker {
    QueueService queueService = QueueService.getInstance();
    ILoggerHandler loggerHandler;
    ScheduledExecutorService Executor = Executors.newSingleThreadScheduledExecutor();
    public Worker( String FilePath )
    {
        ILoggerHandler.logDestination = new FileLogOutput(FilePath);
        loggerHandler = new InfoHandler(new WarningHandler(new ErrorHandler(new NullLoggerHandler()) ) );
        Executor.scheduleWithFixedDelay( this::readFromQueue , 1 , 1 , TimeUnit.MILLISECONDS);
    }

    public void readFromQueue()
    {
        List<Message> msgs = queueService.readFromQueue();

        for( Message msg : msgs )
        {
            loggerHandler.Log( msg );
        }
    }
}
