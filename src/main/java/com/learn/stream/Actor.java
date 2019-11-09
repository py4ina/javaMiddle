package com.learn.stream;

public interface Actor {
    void act();
    void speak();
    default void comedy(){
        System.out.println("I can male people laugh");
    }
}
