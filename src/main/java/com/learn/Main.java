package com.learn;


public class Main {
    public static void main(String[] args) {

    }
}

interface B {
    void b();
}


abstract class A implements B{
    private int a;

    public A(int a) {
        this.a = a;
    }

    public abstract void a();

    @Override
    public void b() {
        System.out.println("fffffffff");
    }

    public static void ff(){
        System.out.println("sdvsavsadv");
    }


}

class C extends A{

    public C(int a) {
        super(a);
    }

    @Override
    public void a() {

    }
}