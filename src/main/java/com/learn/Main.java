package com.learn;

import java.util.*;

public class Main {
    private final static String URL = "jdbc:mysql://10.4.4.8:3306/ukr_pol";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "UkrPol_123";

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(null, "A");
        map.put(null, "B");
        System.out.println(map);
    }

}