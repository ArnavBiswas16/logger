package main.java.LoggingFramework;

import java.io.Serializable;

import static main.java.LoggingFramework.LogManager.addObservers;
import static main.java.LoggingFramework.LogManager.buildChainOfLogger;

public class Logger  implements Cloneable, Serializable {

    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LoggerSubject loggerSubject;

    private Logger(){
        if(logger != null){
            throw  new IllegalStateException("Object already Created");
        }
    }

    public static Logger getLogger(){
        if(logger == null){
            synchronized (Logger.class){
                if(logger == null){
                    logger = new Logger();
                    chainOfLogger = buildChainOfLogger();
                    loggerSubject = addObservers();
                }
            }
        }
        return logger;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return logger;
    }

    private void createMsg(int level, String msg){

        chainOfLogger.logMessage(level, msg, loggerSubject);
    }

    public void info(String msg){
        createMsg(1, msg);
    }
    public void error(String msg){
        createMsg(2, msg);
    }
    public void debug(String msg){
        createMsg(3, msg);
    }


}
