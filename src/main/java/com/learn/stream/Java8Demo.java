package com.learn.stream;

import java.util.Arrays;
import java.util.List;

public class Java8Demo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 20, 35, 46, 55, 68, 75);

        Integer reduce = list.stream()
                .filter(integer-> integer % 5 == 0)
                .map(integer -> integer * 2)
                .findFirst()
                .orElse(0);

        System.out.println(reduce);
    }
}
