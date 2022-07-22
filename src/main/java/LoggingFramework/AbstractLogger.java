package main.java.LoggingFramework;

public abstract class AbstractLogger {

    int level;
     private AbstractLogger nextLevelLogger;

     void setNextLevelLogger(AbstractLogger nextLevelLogger){
         this.nextLevelLogger = nextLevelLogger;
     }

     void logMessage(int level, String msg, LoggerSubject loggerSubject){
         if(level == this.level){
             display(msg, loggerSubject);
         }

         if(nextLevelLogger != null){
             nextLevelLogger.logMessage(level, msg, loggerSubject);
         }
     }

     protected abstract void display(String msg, LoggerSubject loggerSubject);
}
