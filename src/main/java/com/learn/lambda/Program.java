package com.learn.lambda;

public class Program {
    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();

        switcher.consumer = lamp;

        switcher.switchOn();
        switcher.switchOn();
    }
}
