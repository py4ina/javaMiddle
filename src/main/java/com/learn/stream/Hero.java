package com.learn.stream;

public class Hero implements Actor {
    @Override
    public void act() {
        System.out.println("I can Act");
    }

    @Override
    public void speak() {
        System.out.println("I can Speak");
    }

    public static void act2() {
        System.out.println("I can Act");
    }
}
