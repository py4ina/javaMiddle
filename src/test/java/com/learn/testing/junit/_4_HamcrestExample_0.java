package com.learn.testing.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class _4_HamcrestExample_0 {
    private List<String> list;

    @Before
    public void setUp() {
        this.list = new ArrayList<>();
    }

    @Test
    public void test_core_java(){
        list.add("A");
        if (!list.get(0).equals("A")){
            throw new AssertionError();
        }
    }

    @Test
    public void test_junit_long(){
        list.add("A");
        assertTrue(list.get(0).equals("A"));
    }

    @Test
    public void test_hamcrest_long(){
        list.add("A");
        assertThat(list.get(0), is("A"));
    }

    @Test
    public void test_hamcrest_short(){
        list.add("A");
        assertThat(list.get(0), is("A"));
    }

    @Test
    public void test_hamcrest_internal_dsl(){
        list.add("A");
        assertThat(list.get(0), is("A"));
    }
}
