package com.learn.lambda;

public class Program {

    public static void fire(Object sender){
        System.out.println("Program.fire");
    }

    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        switcher.addElectricityListener(lamp);
        switcher.addElectricityListener(radio);

        switcher.addElectricityListener(sender->
                System.out.println("rrr"));

        switcher.addElectricityListener(Program::fire);

        switcher.switchOn();
    }
}