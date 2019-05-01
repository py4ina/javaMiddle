package com.learn.servlet.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

public class SimpleExceptionLogger {

    public void logException(JoinPoint thisJoinPoint, Throwable t){
//        Method m = ((MethodSignature) thisJoinPoint.getSignature()).getMethod();
//        Object[] args = thisJoinPoint.getArgs();
//        Object target = thisJoinPoint.getTarget();
        System.out.println("ASPECT.EXCEPTION-LOGGER: " + t.getMessage());
    }
}
