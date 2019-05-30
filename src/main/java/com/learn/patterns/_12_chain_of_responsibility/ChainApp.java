package com.learn.patterns._12_chain_of_responsibility;

public class ChainApp {
    public static void main(String[] args) {
        SMSLogger smsLogger = new SMSLogger(Level.ERROR);
        FileLogger fileLogger = new FileLogger(Level.DEBUG);
        EmailLogger emailLogger = new EmailLogger(Level.INFO);

        smsLogger.setNext(fileLogger);
        fileLogger.setNext(emailLogger);

        smsLogger.writeMassage("INFO", Level.INFO);
        smsLogger.writeMassage("DEBUG", Level.DEBUG);
        smsLogger.writeMassage("ERROR", Level.ERROR);
    }
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

interface Logger {
    void writeMassage(String message, int level);
}

class SMSLogger implements Logger {
    int priority;
    Logger next;

    public SMSLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMassage(String message, int level) {
        if (level == priority){
            System.out.println("SMS: " + message);
        }
        if (next != null){
            next.writeMassage(message, level);
        }
    }
}

class FileLogger implements Logger {
    int priority;
    Logger next;

    public FileLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMassage(String message, int level) {
        if (level == priority){
            System.out.println("File: " + message);
        }
        if (next != null){
            next.writeMassage(message, level);
        }
    }
}

class EmailLogger implements Logger {
    int priority;
    Logger next;

    public EmailLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMassage(String message, int level) {
        if (level == priority){
            System.out.println("Email: " + message);
        }
        if (next != null){
            next.writeMassage(message, level);
        }
    }
}