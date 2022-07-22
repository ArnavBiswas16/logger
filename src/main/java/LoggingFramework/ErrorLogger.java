package main.java.LoggingFramework;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level){
        this.level = level;
    }
    @Override
    protected void display(String msg, LoggerSubject loggerSubject) {
        String message = " Error: "+ msg;
        loggerSubject.notifyAllObserver(3, message);
    }


}
