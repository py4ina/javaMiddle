package com.learn;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        C c = new C();
//        c.show();
        System.out.println(2 > 2 ? true : false);

    }
}

interface A{
    static void a(){
        System.out.println("aaaaaaaaaa");
    }
    default void show(){
        System.out.println("A.show()");
    }
}

interface B{
    default void show(){
        System.out.println("B.show()");
    }
}

class C implements A, B{
    @Override
    public void show() {
        A.a();
    }
}