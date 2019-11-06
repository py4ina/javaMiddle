package com.learn.lambda.example_1;

public class Lamp implements ElectricityConsumer {

    public void lightOn(){
        System.out.println("Lamp.lightOn");
    }

    @Override
    public void electricityOn(Object sender) {
        lightOn();
    }
}
