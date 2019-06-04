package com.learn.testing.junit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.sin;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class _4_HamcrestExample_1 {
    private static final double ERROR = 0.000_001;

    @Test
    public void test_float_short(){
        assertThat(sin(100.0), is(closeTo(0.0, ERROR)));
    }

    @Test
    public void test_float_long(){
        assertThat(sin(100.0), is(closeTo(0.0, ERROR)));
    }

    @Test
    public void test_hasItem(){
        List<String> list = Arrays.asList("A", "B", "C");
        assertThat(list, hasItem("BBB"));
    }

    @Test
    public void test_X_or_Y(){
        List<String> list = Arrays.asList("A", "X", "Y");
        assertThat(list, anyOf(hasItem("X"), hasItem("Y")));
    }

//    @Test
//    public void test_onlyX_or_onlyY(){
//        List<String> list = Arrays.asList("A", "X", "Y");
//        assertThat(list, anyOf(hasItem("X"), not(hasItem("Y"))),
//                allOf(not(hasItem("X")), hasItem("X")));
//    }
}
