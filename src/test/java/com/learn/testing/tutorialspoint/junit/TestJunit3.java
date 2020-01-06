package com.learn.testing.tutorialspoint.junit;

import junit.framework.AssertionFailedError;
import junit.framework.TestResult;
import org.junit.Test;

public class TestJunit3 extends TestResult {
    // add the error
    public synchronized void addError(Test test, Throwable t) {
        System.out.println("addError");
        super.addError((junit.framework.Test) test, t);
    }

    // add the failure
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        System.out.println("addFailure");
        super.addFailure((junit.framework.Test) test, t);
    }

    @Test
    public void testAdd() {
        // add any test
    }

    // Marks that the test run should stop.
    public synchronized void stop() {
        System.out.println("stop");
        //stop the test here
    }
}
