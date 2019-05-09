package com.learn.log4j;

import org.apache.log4j.Logger;

public class HelloExample {
    final static Logger logger = Logger.getLogger(HelloExample.class);

    public static void main(String[] args) {
        logger.debug("Log4jExample: A Sample Debug Message");
        logger.info("Log4jExample: A Sample Info  Message");
        logger.warn("Log4jExample: A Sample Warn  Message");
        logger.error("Log4jExample: A Sample Error Message");
        logger.fatal("Log4jExample: A Sample Fatal Message");

//        HelloExample obj = new HelloExample();
//        obj.runMe("mkyong");

    }

    private void runMe(String parameter){

        if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }
}
