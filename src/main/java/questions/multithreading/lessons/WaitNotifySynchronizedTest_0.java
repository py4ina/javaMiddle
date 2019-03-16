package questions.multithreading.lessons;

public class WaitNotifySynchronizedTest_0 {

    public static void main(String[] args) {
        f();
    }

    private static void f() {
        Class aClass = WaitNotifySynchronizedTest_0.class;

        synchronized (aClass){
            aClass.notify();
        }
    }
}