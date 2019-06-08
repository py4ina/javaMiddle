package com.learn.testing.Mockito;

import org.mockito.Mockito;

import java.util.List;

public class _20_verify_arg {
    public static void main(String[] args) {
        List list = Mockito.mock(List.class);

        list.add("A");
        list.remove("B");
        list.add("B");
    }
}
