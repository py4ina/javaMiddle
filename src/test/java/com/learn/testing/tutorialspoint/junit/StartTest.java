package com.learn.testing.tutorialspoint.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestJunit1.class ,TestJunit2.class
})
public class StartTest {}