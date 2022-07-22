package main.java.LoggingFramework;

public class InfoLogger extends AbstractLogger{

    public InfoLogger(int level){
        this.level = level;
    }

    @Override
    protected void display(String msg, LoggerSubject loggerSubject) {
        String message = " INFO: "+ msg;
        loggerSubject.notifyAllObserver(1, message);
    }
}
