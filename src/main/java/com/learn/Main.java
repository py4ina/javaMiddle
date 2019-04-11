package com.learn;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
//import org.apache.commons.lang3.ArrayUtils;

public class Main {
    public static void main(String[] args) {
        int[] n = {1, 5, 15, 2, 8, 6, 7};
//        System.out.println(n.toString());
        List<Integer> list = Arrays.asList(ArrayUtils.toObject(n));
    }
}