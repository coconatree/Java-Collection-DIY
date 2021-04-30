package APPLICATION;

import LOGGER.Logger;
import LOGGER.LoggerFactory;

import static LOGGER.Logger.Level.*;

public class Application
{
    private static Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private ApplicationContext APPLICATION_CONTEXT = null;

    public void setApplicationContext(ApplicationContext ctx)
    {
        this.APPLICATION_CONTEXT = ctx;
    }

    private void prepare()
    {
        if(this.APPLICATION_CONTEXT == null)
        {
            LOGGER.LOG(ERROR, "APPLICATION CONTEXT CAN'T BE NULL - PLEASE SET THE CONTEXT BEFORE STARTING THE APPLICATION");
            System.exit(-1);
        }
    }

    public void run()
    {
        this.prepare();

        // Programme Entry Point

        LOGGER.LOG(INFO, "HELLO WORLD !!!");
    }
}
