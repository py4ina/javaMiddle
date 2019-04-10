package com.learn.patterns._16_state;

public class StateApp {
    public static void main(String[] args) {
//        Station dfm = new RadioDFM();
//        Radio radio = new Radio();
//        radio.setStation(dfm);
//
//        for (int i = 0; i < 10; i++) {
//            radio.play();
//            radio.nextStation();
//        }
        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i < 10; i++) {
            human.doSomething();
        }
    }
}
/** --Station-- **/
interface Station {
    void play();
}

class Radio7 implements Station {
    @Override
    public void play() {
        System.out.println("Radio7.play()");
    }
}

class RadioDFM implements Station {
    @Override
    public void play() {
        System.out.println("RadioDFM.play()");
    }
}

class VestiFM implements Station {
    @Override
    public void play() {
        System.out.println("VestiFM.play()");
    }
}
/** State **/
class Radio {
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    void nextStation(){
        if (station instanceof Radio7){
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM){
            setStation(new VestiFM());
        } else if (station instanceof VestiFM){
            setStation(new Radio7());
        }
    }

    void play(){
        station.play();
    }
}


/** --Human-- **/
class Human{
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething(){
        state.doSomething(this);
    }
}

/** State **/
interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {
    @Override
    public void doSomething(Human context) {
        System.out.println("Work.doSomething()");
        context.setState(new Weekend());
    }
}

class Weekend implements Activity {
    private int count = 0;

    @Override
    public void doSomething(Human context) {
        if (count < 3){
            System.out.println("Weekend.doSomething()");
            count++;
        } else {
            context.setState(new Work());
        }
    }
}