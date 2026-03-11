package Logger.QueueService;

import Logger.Entities.Message;
import java.util.*;

import java.util.concurrent.PriorityBlockingQueue;

public class QueueService {
    private static QueueService  instance = new QueueService();
    PriorityBlockingQueue<Message> pbq =  new PriorityBlockingQueue<>();
    QueueService() {
            System.out.println("New Queue service Started ");
    }
    public static QueueService getInstance( )
    {
        return instance;
    }

    public void addToQueue(Message message)
    {
        // we can add logic for Idempotency Check ( Optional )
        pbq.add( message );
    }

    public List<Message> readFromQueue()
    {
        List<Message> l = new ArrayList<>();
        while( !pbq.isEmpty() )
            l.add( pbq.poll() );

        return pbq.isEmpty() ? null : l;
    }
}
