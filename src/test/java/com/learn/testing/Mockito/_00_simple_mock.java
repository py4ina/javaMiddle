package com.learn.testing.Mockito;

import org.junit.Ignore;

import java.util.List;

import static org.mockito.Mockito.mock;

@Ignore
public class _00_simple_mock {

    public static void main(String[] args) {
        List<String> list = mock(List.class);
        System.out.println(list.add("A"));
        System.out.println(list.get(-1));
        System.out.println(list.size());
        System.out.println(list.iterator());

        System.out.println(list.getClass().getName());
    }
}