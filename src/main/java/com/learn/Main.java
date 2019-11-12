package com.learn;


import java.util.List;
import java.util.function.BinaryOperator;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;

        List<Integer> list = asList(1, 2, 3, 4);

        int sum = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                        2),
                3);

        System.out.println(sum);

    }
}