package com.learn.equals_hashCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map map = new TreeMap((o1, o2) -> 0);
        map.put(new PhoneNumber(408, 867, 5309), "Jenny");
        map.put(new PhoneNumber(408, 867, 5308), "Jenny");

        System.out.println(map.get(new PhoneNumber(408, 867, 5309)));
    }
}
