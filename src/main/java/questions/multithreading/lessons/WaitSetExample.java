package questions.multithreading.lessons;

public class WaitSetExample {

    public static void main(String[] args) {
        WaitSetExample ref = new WaitSetExample();
        for (int k = 0; k < 5; k++) {
            new Thread(new WaitMethodCaller(ref, k)).start();
        }
    }

    public synchronized void f(int x) throws InterruptedException {
        System.out.println("+" + x);
        this.wait();
        System.out.println("-" + x);
    }
}
