package com.learn;

public class Main {
    public static void main(String[] args) {
//        for (Object property: System.getProperties().keySet()) {
//
//            System.out.println(property + " -> " + System.getProperty((String) property));
//        }

        String rootPath = System.getProperty("user.dir");
        System.out.println(rootPath + "/src/main/resources/learnFiles/");
    }
}