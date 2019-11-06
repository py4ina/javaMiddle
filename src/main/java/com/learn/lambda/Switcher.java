package com.learn.lambda;

import java.util.ArrayList;
import java.util.List;

public class Switcher {

    private List<ElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricityListener(ElectricityConsumer listener){
        listeners.add(listener);
    }

    public void removelectricityListener(ElectricityConsumer listener){
        listeners.remove(listener);
    }

    public void switchOn(){
        System.out.println("Switcher.switchOn");

        for (ElectricityConsumer consumer: listeners) {
            consumer.electricityOn(consumer);
        }
    }
}
