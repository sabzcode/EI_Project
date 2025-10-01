class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("[Logger] Creating new instance");
    }

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("System started");

        Logger logger2 = Logger.getInstance();
        logger2.log("Another log message");

        System.out.println("Logger instances same? " + (logger1 == logger2));
    }
}