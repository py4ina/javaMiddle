package com.learn;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    private final static String URL = "jdbc:mysql://10.4.4.8:3306/ukr_pol";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "UkrPol_123";

    public static void main(String[] args) {
        ArrayList<String> states = new ArrayList<>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");

        Iterator<String> iter = states.iterator();
        while(iter.hasNext()){

            System.out.println(iter.next());
        }
    }
}