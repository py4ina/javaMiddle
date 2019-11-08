package com.learn.stream;

import java.util.Arrays;
import java.util.List;

public class Java8Demo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        list.stream()
                .filter(integer -> integer > 3)
                .forEach(i -> System.out.println(i));
    }
}