package com.learn.testing.junit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _0_OkFailExample {

    @Test
    public void test_size_after_add_one(){
        List<String> list = new ArrayList<>();
        list.add("A");
        if (list.size() != 1) {
            throw new AssertionError();
        }
    }

    @Test
    public void test_size_add_two(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("A");
        if (list.size() != 2) {
            throw new AssertionError();
        }
    }

    @Test
    public void test_convert_A_to_B(){
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("A");
//        if (list.size() != 2) {
//            throw new AssertionError();
//        }
    }
}