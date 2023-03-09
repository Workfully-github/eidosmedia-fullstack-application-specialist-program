package org.workfully.controllers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

    private static final Logger log = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        processData();
    }

    public static void processData(){

        log.log(Level.INFO, "test");

        log.trace("FROM TRACE METHOD");
        log.warn("FROM WARN METHOD");
        log.debug("FROM DEBUG METHOD");
        log.info("FROM INFO METHOD");
        log.error("FROM ERROR METHOD");
        log.fatal("FROM FATAL METHOD");
    }
    
}
