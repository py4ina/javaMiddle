package com.learn.lambda;

public class Lamp implements ElectricityConsumer {

    public void lightOn(){
        System.out.println("Lamp.lightOn");
    }

    @Override
    public void electricityOn() {
        lightOn();
    }
}
