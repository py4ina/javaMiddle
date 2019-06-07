package com.learn.testing.Mockito;

import org.mockito.ArgumentMatcher;

import java.util.List;

import static org.mockito.Matchers.intThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class _12_when_arg_matcher {
    public static void main(String[] args) {
        List<String> list = mock(List.class);
        ArgumentMatcher<Integer> matcher = new ArgumentMatcher<Integer>() {
            @Override
            public boolean matches(Object argument) {
                return ((Integer) argument) % 3 == 0;
            }
        };

        when(list.get(intThat(matcher))).thenReturn("Hello!");

        System.out.println(list.size());

        for (int k = 0; k < 10; k++){
            System.out.println("list.get("+k+"): " + list.get(k));
        }
    }
}
