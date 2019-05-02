package com.learn.patterns._15_observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        MeteorStation station = new MeteorStation();

        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());

        station.setMeasurements(25, 760);
    }
}



interface Observed {
    void addObserver(Observer observer);
    void removeObserved(Observer observer);
    void notifyObservers();
}
interface Observer {
    void handleEvent(int temperature, int pressure);
}


class MeteorStation implements Observed {

    int temperature;
    int pressure;
    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserved(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(temperature, pressure);
        }
    }

}


class ConsoleObserver implements Observer {

    @Override
    public void handleEvent(int temperature, int pressure) {
        System.out.println("ConsoleObserver.temperature = " + temperature + ", ConsoleObserver.pressure = " + pressure);
    }
}

class FileObserver implements Observer {

    @Override
    public void handleEvent(int temperature, int pressure) {
//        File file;
        try {
            File file = File.createTempFile("TempPressure", "txt");
            PrintWriter pw = new PrintWriter(file);
            pw.print("ConsoleObserver.temperature = " + temperature + ", ConsoleObserver.pressure = " + pressure);
            pw.println();
            pw.close();

            System.out.println("ConsoleObserver.temperature = " + temperature + ", ConsoleObserver.pressure = " + pressure);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}