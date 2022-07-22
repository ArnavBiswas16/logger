package main.java.LoggingFramework;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.info("you got info");
        logger.error("error");
        logger.debug("debug");

    }
}
