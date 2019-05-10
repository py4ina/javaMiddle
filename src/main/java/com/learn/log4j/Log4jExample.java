package com.learn.log4j;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class Log4jExample {
    static Logger log = Logger.getLogger(Log4jExample.class.getName());

    public static void main(String[] args) throws IOException,SQLException {
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
    }
}
