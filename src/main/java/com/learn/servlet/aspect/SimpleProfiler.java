package com.learn.servlet.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleProfiler {

    public Object profile(ProceedingJoinPoint call, int id) throws Throwable {
        long t0 = System.nanoTime();
        try {
            return call.proceed();
        } finally {
            long t1 = System.nanoTime();
            System.out.println("ASPECT.PROFILER: " + call.toString() + ", dt: " + (t1 - t0));
        }
    }
}
