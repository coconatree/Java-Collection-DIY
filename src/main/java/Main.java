import APPLICATION.Application;
import APPLICATION.ApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        Application app = new Application();
        app.setApplicationContext(ApplicationContext.getInstance());
        app.run();
    }
}
