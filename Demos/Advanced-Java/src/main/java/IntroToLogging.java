/*

Log4j is a logging framework that we can use in our applications to track events/ bugs as they occur in runtime

What is logging?
    - logging is the process of writing log messages during the execution
    of a program to a centralized place or location

    Advantages :
        - allows you to report and persist errors and warnings as well as information that can
        later be retrieved and analyzed

        - allows for better quality debugging since we can track the source of the error during execution

        - Logging Levels :
            - ALL = includes all levels
            - DEBUG = used to designate information events that are useful to debug an app
            - INFO = used to designate informational events that highlight the progress of an app
            - WARN = used to designate potentially harmful situations
            - ERROR = designates error events that might still allow the app to continue running
            - FATAL = designates very severe error events that will presumably lead to the app aborting (crash)
            - OFF = turning off logging throughout the application
* */


import org.apache.log4j.Logger;

public class IntroToLogging {

    private static Logger log = Logger.getLogger(IntroToLogging.class);

    public static void main(String[] args){
        log.info("Hello World , I'm Info");
        log.warn("Hello Info, I'm Warning");
        log.error("Hello Warning, I'm Error");

    }






}
