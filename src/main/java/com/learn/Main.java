package com.learn;


import java.util.StringTokenizer;

public class Main {
    static String IN = "Название=Учим Java с нуля;" +
            "Автора=Pro-java.ru;" +
            "Издательство=Javadocdoc;" +
            "Авторское право=2017";

    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer(IN, "=;");

        while (stringTokenizer.hasMoreTokens()){
//            System.out.println(stringTokenizer.nextToken());
            String key = stringTokenizer.nextToken();
            String val = stringTokenizer.nextToken();

            System.out.println(key + " -> " + val);
        }
    }
}