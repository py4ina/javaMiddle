package com.learn.testing.Mockito;

import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class _10_when_eq {
    public static void main(String[] args) {
        List<String> list = mock(List.class);
        when(list.get(eq(5))).thenReturn("A");
        when(list.get(eq(6))).thenReturn("B");
        for (int k = 0; k < 10; k++){
            System.out.println("list.get("+k+"): " + list.get(k));
        }
    }
}