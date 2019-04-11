package com.learn;

public class Main {
    static Integer str = new Integer(1);

    public static void changeIt(Integer s) {
        s = 2;
    }

    public static void main(String[] args) {
        changeIt(str);
        System.out.println(str);
    }
}