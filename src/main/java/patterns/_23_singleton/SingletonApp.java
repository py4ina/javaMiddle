package patterns._23_singleton;

public class SingletonApp {
    public static void main(String[] args) {
        final int size = 1000;
        Singleton arr[] = new Singleton[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Singleton.getInstance();
        }
        System.out.println(Singleton.counter);
    }
}


class Singleton{
    public static int counter = 0;
    private static Singleton instance;

    private Singleton() {
        counter++;
    }

    public static Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}