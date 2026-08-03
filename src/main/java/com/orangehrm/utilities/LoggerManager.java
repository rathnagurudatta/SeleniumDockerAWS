package com.orangehrm.utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerManager {

    //public static Logger logger;

    private LoggerManager(){

    }

    public static Logger getLogger(Class<?> className){
        Logger logger = null;
        if(logger == null){
            return LogManager.getLogger();
        }
        return logger;
    }

}
