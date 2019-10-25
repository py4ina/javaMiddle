package com.learn;


import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> current = new TreeSet<>();
        current.add(1);
        current.add(2);
        current.add(3);
        Set<Integer> previously = new TreeSet<>();
        previously.add(3);
        previously.add(2);
        previously.add(6);
//        Collections.
        System.out.println(current);
        System.out.println(current.retainAll(previously));
        System.out.println(current);
    }
}
