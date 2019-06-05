package com.learn.testing.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static java.util.Arrays.asList;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class _8_ParametrizedExample {
    @Parameters
    public static Iterable<Object[]> data() {
        return asList(new Object[][]{{-3, 3}, {-2, 2}, {-1, 1}, {0, 0}, {1, 1}, {2, 2}, {3, 3}});
    }

    @Parameter(0)
    public int input;

    @Parameter(1)
    public int expectedResult;

//    @Test
//    public void test(){
//        assertThat(/*abs*/(input), is(expectedResult));
//    }
}
