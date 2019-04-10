package com.learn.patterns._3_factory_method;

import java.util.Date;

public class FactoryMethodApp {
    public static void main(String[] args) {
        WatchMaker maker = getMakerByName("Digit444444444");
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker) {
        if (maker == "Digital") {
            return new DigitalWatchMaker();
        } else if (maker == "Rome"){
            return new RomeWatchMaker();
        } else {
            throw new  RuntimeException("Watch '" + maker + "' is not exist!");
        }
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println("DigitalWatch.showTime(): " + new Date());
    }
}

class RomeWatch implements Watch {
    public void showTime() {
        System.out.println("RomeWatch.showTime(): " + new Date());
    }
}

//--------------------------------------------

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new RomeWatch();
    }
}