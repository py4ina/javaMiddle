package com.learn;

public class Main {
    private static int i = 0;
    public static void main(String[] args) {
        System.out.println(i++);
        try {
            main(args);
        } catch (Throwable e){
            System.out.println(e);
           main(args);
        }
    }
}