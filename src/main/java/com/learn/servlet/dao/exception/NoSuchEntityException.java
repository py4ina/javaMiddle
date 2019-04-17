package com.learn.servlet.dao.exception;

public class NoSuchEntityException extends DaoBusinesException{

    public NoSuchEntityException(String s) {
        super(s);
    }

    public NoSuchEntityException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
