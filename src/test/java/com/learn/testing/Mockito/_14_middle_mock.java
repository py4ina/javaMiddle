package com.learn.testing.Mockito;

import org.mockito.ArgumentMatcher;

import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.intThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class _14_middle_mock {
    public static void main(String[] args) {
        List<String> list = mock(List.class);

        when(list.get(anyInt())).thenReturn("0");
        when(list.get(5)).thenReturn("A");

        ArgumentMatcher<Integer> matcher = new ArgumentMatcher<Integer>() {
            @Override
            public boolean matches(Object argument) {
                return ((Integer) argument) % 3 == 0;
            }
        };

        when(list.get(intThat(matcher))).thenReturn("every third");
        when(list.get(9)).thenThrow(new RuntimeException("Boo!"));

        for (int k = 0; k < 10; k++){
            System.out.println("list.get("+k+"): " + list.get(k));
        }
    }
}