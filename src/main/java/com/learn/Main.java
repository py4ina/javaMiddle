package com.learn;

public class Main {

    public static void main(String[] args) {
        Double d1 = Double.MAX_VALUE;
        Double d2 = Double.MAX_VALUE;

        System.out.println(d1.hashCode());
//        d2 = d2 +100000000000000000000000000.1;
        System.out.println(d2.hashCode());

        System.out.println(d2.equals(d1));
        System.out.println(d1.hashCode() == d2.hashCode());
    }
}