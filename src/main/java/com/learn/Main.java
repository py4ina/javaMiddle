package com.learn;

import java.util.*;

public class Main {
    private final static String URL = "jdbc:mysql://10.4.4.8:3306/ukr_pol";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "UkrPol_123";

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

//        checkTime(list, list.getClass().getName());

        list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = ((LinkedList<Integer>) list).descendingIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



//        checkTime(list, list.getClass().getName());
    }

    private static void checkTime(List<Integer> list, String collection) {
        long start = System.nanoTime();
        list.contains(5_000_000);
        long finish = System.nanoTime();
        System.out.println(collection + " : "+ (finish - start));
    }
}