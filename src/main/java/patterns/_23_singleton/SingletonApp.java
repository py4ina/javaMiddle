package patterns._23_singleton;

public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        final int size = 1000;

        Thread arr[] = new Thread[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Thread(new R());
            arr[i].start();
        }

        for (int i = 0; i < size; i++) {
            arr[i].join();
        }
        System.out.println(Singleton.counter);
    }
}

class R implements Runnable{
    @Override
    public void run() {
        Singleton.getInstance();
    }
}


class Singleton{
    static int counter = 0;
    private static Singleton instance;

    private Singleton() {
        counter++;
    }

    static Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}