package com.learn.servlet.dao.exception;

public class DaoException extends Exception {
    public DaoException(String s) {
        super(s);
    }

    public DaoException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
