package patterns._2_facade;

public class FacadeApp {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power {
    void on(){
        System.out.println("Power.on()");
    }

    void off(){
        System.out.println("Power.off()");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean isData() {
        return data;
    }

    void load() {
        data = true;
    }

    void unLoad() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvdRom) {
        if (dvdRom.isData()) {
            System.out.println("Copy data ...");
        } else {
            System.out.println("Insert dvd with data!");
        }
    }
}