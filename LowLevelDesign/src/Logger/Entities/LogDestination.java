package Logger.Entities;

public abstract class LogDestination{
    public abstract void Append(Message message);
}
