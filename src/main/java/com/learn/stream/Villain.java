package com.learn.stream;

public class Villain implements Actor {
    @Override
    public void act() {
        System.out.println("I can Act");
    }

    @Override
    public void speak() {
        System.out.println("I can Speak");
    }

    public void rude(){
        System.out.println("I am rude");
    }
}
