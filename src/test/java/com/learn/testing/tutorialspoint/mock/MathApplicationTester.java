package com.learn.testing.tutorialspoint.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd(){
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //add the behavior of calc service to subtract two numbers
        when(calcService.subtract(20.0,10.0)).thenReturn(10.00);

        //test the add functionality
        assertEquals(calcService.add(10.0, 20.0),30.0,0);
        assertEquals(calcService.add(10.0, 20.0),30.0,0);
        assertEquals(calcService.add(10.0, 20.0),30.0,0);

        assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0.0);

        //default call count is 1
        verify(calcService, atLeastOnce()).subtract(20.0, 10.0);

        //check if add function is called three times
        verify(calcService, atLeast(2)).add(10.0, 20.0);

        //verify that method was never called on a mock
        verify(calcService, atMost(3)).multiply(10.0,20.0);
    }
}
