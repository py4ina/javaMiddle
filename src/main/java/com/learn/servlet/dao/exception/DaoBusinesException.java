package com.learn.servlet.dao.exception;

public class DaoBusinesException extends DaoException {
    public DaoBusinesException(String s) {
        super(s);
    }

    public DaoBusinesException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
