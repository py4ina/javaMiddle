package com.learn.testing.junit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class _XXX_test_arrayList_addAll {
    @Test
    public void test_all(){
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("1", "2", "3"));
        list.addAll(Arrays.asList("1", "2", "3"));
        list.addAll(Arrays.asList("1", "2", "3"));
        System.out.println(list);
    }
}
