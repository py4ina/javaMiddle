package com.learn;


import com.learn.enum_lern.Country;

import java.util.IntSummaryStatistics;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
//        LongStream stream = LongStream.of(3l, 4l, 7l, 9l, 11l);
//
//        IntSummaryStatistics intSummaryStatistics = stream
//                .mapToInt(value -> Integer.parseInt(String.valueOf(value)))
//                .summaryStatistics();
//
//        System.out.println(intSummaryStatistics.getSum());
//        System.out.println(intSummaryStatistics.getAverage());

        r((Predicate<Integer>)i -> true);

    }

    private static void r(Predicate<Integer> predicate){
        System.out.println("Predicate");
    }

    private static void r(IntPredicate predicate){
        System.out.println("IntPredicate");
    }
}