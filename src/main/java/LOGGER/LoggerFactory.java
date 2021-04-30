package LOGGER;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.of;

public class LoggerFactory
{
    private static Map<Class, Logger> LoggerMap = new HashMap<>();

    public static Logger getLogger(Class cls)
    {
        return findLogger(cls);
    }

    private static Logger findLogger(Class cls)
    {
        if(LoggerMap.containsKey(cls))
            return LoggerMap.get(cls);
        else
        {
            Logger LOGGER =  new Logger(cls);
            LoggerMap.put(cls, LOGGER);
            return LOGGER;
        }
    }
}
