package APPLICATION;

import CONFIGURATION.Config;
import lombok.Getter;
import lombok.Setter;

public class ApplicationContext
{
    private static ApplicationContext INSTANCE = null;

    @Getter
    @Setter
    private String CONFIGURATION_PATH = "/home/spayki/Desktop/JavaDataStructuresGithub/JavaDataStructures/JAVA_LOGGER_CUSTOM/src/main/java/Application.prop";

    @Getter
    private Config APPLICATION_CONFIG;

    private ApplicationContext()
    {
        APPLICATION_CONFIG = Config.getInstance(CONFIGURATION_PATH);
    }

    public static ApplicationContext getInstance()
    {
        if(INSTANCE == null)
            INSTANCE = new ApplicationContext();
        return INSTANCE;
    }
}
