package com.learn.servlet.dao.exception;

public class DaoSystemException extends DaoException {
    public DaoSystemException(String s) {
        super(s);
    }

    public DaoSystemException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
