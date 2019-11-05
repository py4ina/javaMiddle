package com.learn.lambda;

public class Switcher {

    public ElectricityConsumer consumer;

    public void switchOn(){
        System.out.println("Switcher.switchOn");

        if (consumer != null){ consumer.electricityOn(); }
    }
}
