package com.learn;


import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = asList(1, 2, 3, 4);

        int i = list.stream()
                .reduce(0, (x, y) ->
                        {
                            System.out.println(x + ", " + y);
                            return x + y;
                        }
                );
        System.out.println(i);


    }
}