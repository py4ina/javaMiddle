package com.learn;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String s = "Я стану программистом!";
        s = s.concat(" Очень хорошим программистом!");

        System.out.println(s);
    }
}

class A {
    protected A a(){
        return new A();
    }

    public void b(){
        System.out.println("A.b()");
    }
}

class B extends A{
    @Override
    public void b() {
        super.b();
    }

    @Override
    public B a() {
        return new B();
    }
}