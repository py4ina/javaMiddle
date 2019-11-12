package com.learn;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<String> list = Stream.of("a", "b", "hello")
                .map(s -> s.toUpperCase())
                .collect(toList());
        System.out.println(list);


//        long count = list.stream()
//                .filter(integer -> integer < 2)
//                .count();
//        System.out.println(count);
    }
}