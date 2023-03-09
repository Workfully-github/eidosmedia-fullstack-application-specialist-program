package org.workfully.log;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GlobalLogger {

    private static Logger logger = Logger.getLogger("global");

    public static void init() {
        FileHandler fh;
        try {
            fh = new FileHandler("src/main/java/org/workfully/log/global.log");

            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());

            logger.info("Logger Initialized");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception :", e);
        }
    }

    public static void main(String[] args) {
        init();
        for (int i = 0; i < 2; i++) {
        try {
                int a = 10 / 0; // Aritmetic Exception
                
            } catch (Exception e) {
                logger.log(Level.WARNING, "Exception", e);
            }
        }

        logger.info("Program Ended");
    }
}
