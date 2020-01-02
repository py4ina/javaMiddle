package com.learn.testing.tutorialspoint;

import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestJunit {
    String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        message = "New Word";
        assertEquals(message, messageUtil.printMessage());
    }
}
