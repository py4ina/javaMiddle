package com.learn.testing.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class _13_thenThrow {
    public static void main(String[] args) {
        List<String> list = mock(List.class);

        when(list.get(9)).thenThrow(new RuntimeException("Boo!"));

        for (int k = 0; k < 10; k++){
            System.out.println("list.get("+k+"): " + list.get(k));
        }
    }
}
