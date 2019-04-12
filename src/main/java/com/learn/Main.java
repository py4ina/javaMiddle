package com.learn;

public class Main {

    static String str = "Value 1";

    public static void changeIt(String s) {
        s = "Value 2";
    }

    public static void main(String[] args) {
//        changeIt(str);
//        System.out.println(str);
        String s1 = new String("A");
        String s2 = s1;
        System.out.println(s1 + ", "+ s2);
        s1 = new String("B");
        System.out.println(s1 + ", "+ s2);
    }
}