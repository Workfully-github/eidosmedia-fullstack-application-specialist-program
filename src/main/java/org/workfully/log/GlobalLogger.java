package org.workfully.log;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GlobalLogger {

    private static Logger logger = Logger.getLogger("global");

    static {
        FileHandler fh;
        try {
            fh = new FileHandler("src/main/java/org/workfully/log/global.log", true);

            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());

            logger.info("Logger Initialized");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception :", e);
        }
    }

    public static void writeLogInfo(String msg){
        logger.info(msg);
    }

    public static void writeLogWarning(String msg, Exception e){
        logger.log(Level.WARNING, msg, e);
    }

    public static void writeLog(String msg, Exception e, Level level){
        logger.log(level, msg, e);
    }

    public static void main(String[] args) {
        try {
                int a = 10 / 0; // Aritmetic Exception
                
            } catch (Exception e) {
                logger.log(Level.WARNING, "Exception", e);
            }
    

        logger.info("Program Ended");
    }
}
