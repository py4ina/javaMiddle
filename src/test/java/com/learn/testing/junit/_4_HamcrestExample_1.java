package com.learn.testing.junit;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
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

    @Test
    public void test_onlyX_or_onlyY(){
        List<String> list = Arrays.asList("A", "*", "Y");
        assertThat(list,
                anyOf(
                        allOf(hasItem("X"), not(hasItem("Y"))),
                        allOf(not(hasItem("X")), hasItem("X")))
        );
    }

    @Test
    public void test_twoX_by_hands(){
        List<String> list = Arrays.asList("A", "X", "X", "*", "+");
        int firstIndex = list.indexOf("X");
        System.out.println(firstIndex);
        int secondIndex = list.subList(firstIndex + 1, list.size()).indexOf("X");
        System.out.println(secondIndex);
        int thirdIndex = list.subList(firstIndex + secondIndex + 2, list.size()).indexOf("X");
        System.out.println(thirdIndex);
        if (!(firstIndex >= 0 && secondIndex >= 0 && thirdIndex < 0)) {
            throw new AssertionError();
        }
    }

    @Test
    public void test_twoX_by_custom_matcher(){
        List<String> list = Arrays.asList("A", "X", "X", "*", "+");
        assertThat(list, haStrictCount("X", 2));
    }

    private static <T> Matcher<Collection<T>>haStrictCount(T expectedElem, int expectedCount) {
        return new BaseMatcher<Collection<T>>() {

            private int actualCount;
            private Object arg;
            @Override
            public boolean matches(Object item) {
                arg = item;
                actualCount = 0;
                for (T value : ((Iterable<T>) item)) {
                    actualCount += value.equals(expectedElem) ? 1 : 0;
                }
                return actualCount == expectedCount;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(expectedCount+" of '"+expectedElem+"' But: "+ actualCount);
            }
        };
    }

//    private static class HasStrictMatcher<T> extends BaseMatcher<Collection<T>> {
//
//    }
}
