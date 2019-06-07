package com.learn.testing.Mockito;

import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class _11_when_all {
    public static void main(String[] args) {
        List<String> list = mock(List.class);

        when(list.size()).thenReturn(Integer.MAX_VALUE);
        when(list.get(anyInt())).thenReturn("Hello!");

        System.out.println(list.size());

        for (int k = 0; k < 10; k++){
            System.out.println("list.get("+k+"): " + list.get(k));
        }
    }
}
