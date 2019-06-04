package com.learn.testing.junit;

import org.junit.*;

public class _1_LifeCycleExample_1 {
    public _1_LifeCycleExample_1() {
        System.out.println("constructor()");
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass");
    }

    @Before
    public void setUp() {
        System.out.println("Before");
    }

    @Test
    public void test_0(){
        System.out.println("test_0");
    }

    @Test
    public void test_1(){
        System.out.println("test_1");
    }

    @Test
    public void test_2(){
        System.out.println("test_2");
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("AfterClass");
    }
}
