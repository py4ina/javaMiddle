package com.learn.testing.junit;

import org.junit.Ignore;
import org.junit.Test;

public class _3_IgnoreExample {

    @Test
    public void testOk(){
        System.out.println("testOk()");
    }

    @Ignore
    @Test
    public void testFailButIgnored(){
        System.out.println("testFailButIgnored()");
        throw new RuntimeException();
    }
}

