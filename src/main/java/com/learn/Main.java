package com.learn;


import java.util.IntSummaryStatistics;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        LongStream stream = LongStream.of(3l, 4l, 7l, 9l, 11l);

        IntSummaryStatistics intSummaryStatistics = stream
                .mapToInt(value -> Integer.parseInt(String.valueOf(value)))
                .summaryStatistics();

        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getAverage());
    }
}