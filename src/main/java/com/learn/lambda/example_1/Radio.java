package com.learn.lambda.example_1;

public class Radio implements ElectricityConsumer {

    public void playMusic(){
        System.out.println("Radio.playMusic");
    }

    @Override
    public void electricityOn(Object sender) {
        playMusic();
    }
}
