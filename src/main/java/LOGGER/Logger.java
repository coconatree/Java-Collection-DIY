package LOGGER;

public class Logger
{
    private Class cls;

    public enum Level
    {
        INFO,
        WARN,
        DEBUG,
        ERROR
    }

    public void LOG(Level level, String message)
    {
        System.out.println(String.format("[ %s ] - %s ", level, message));
    }

    protected Logger(Class cls)
    {
        this.cls = cls;
    }

    public Class getCls()
    {
        return this.cls;
    }
}
