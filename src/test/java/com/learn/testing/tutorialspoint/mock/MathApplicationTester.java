package com.learn.testing.tutorialspoint.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    private MathApplication mathApplication;
    private CalculatorService calcService;

    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }


    @Test
    public void testAdd(){
        when(calcService.add(20.0, 10.0))
                .thenAnswer((Answer<Double>) invocation -> {
                    Object[] args = invocation.getArguments();
                    Object mock = invocation.getMock();
                    return 30.0;
                })
                .thenThrow(IllegalArgumentException.class);

        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
    }
}
