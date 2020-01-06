package com.learn.testing.tutorialspoint.junit;

import junit.framework.TestCase;
import org.junit.Test;

public class TestJunit2 extends TestCase {
    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";
        assertEquals(message,messageUtil.salutationMessage());
    }
}
