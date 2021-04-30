package CONFIGURATION;

import FILE_UTILITY.FileUtility;

import LOGGER.Logger;
import LOGGER.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static LOGGER.Logger.Level.*;

public class Config
{
    private Logger LOGGER = LoggerFactory.getLogger(Config.class);

    private static Config INSTANCE;

    private ConfigMapper configMapper;

    private final Map<String, String> CONFIG;

    private Config(String filename)
    {
        this.configMapper = new ConfigMapper();
        this.CONFIG = configMapper.createConfig(filename);
        LOGGER.LOG(INFO, "Config file parsed");
        LOGGER.LOG(INFO, "Configuration : " + this.CONFIG.toString());
    }

    public static Config getInstance(String filename)
    {
        if(INSTANCE == null)
            INSTANCE = new Config(filename);
        return INSTANCE;
    }

    @Override
    public String toString()
    {
        return this.CONFIG.keySet().stream().map(x -> "Key : " + x + " Value : " + this.CONFIG.get(x) + "\n").reduce((value, next) -> value + next).orElseThrow();
    }
}

class ConfigMapper
{
    private Logger LOGGER = LoggerFactory.getLogger(ConfigMapper.class);

    protected ConfigMapper(){}

    protected Map<String, String> createConfig(String filename)
    {
        return FileUtility
                .openFile(filename)
                .orElseThrow()
                .stream()
                .flatMap(x -> x.parser(" ".charAt(0)).stream())
                .collect(Collectors.toMap(key -> key.get(1), value -> value.get(1)));
    }
}
