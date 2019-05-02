package com.learn;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        B b = new B();
        b.getAField();
    }
}

class A {
    private String field = "I'm private field";
}

class B {

    public void getAField() throws NoSuchFieldException, IllegalAccessException {
        A a = new A();
        Field field = A.class.getDeclaredField("field");
        field.setAccessible(true);
        String s = (String) field.get(a);
        System.out.println(s);
    }
}