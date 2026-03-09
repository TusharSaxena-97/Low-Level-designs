package Logger.Entities;

public class ConsoleLogOutput extends LogDestination{
    @Override
    public void Append(Message message) {
        System.out.println(message.toString());
    }
}
