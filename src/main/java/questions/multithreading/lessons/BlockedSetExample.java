package questions.multithreading.lessons;

public class BlockedSetExample {
    public static void main(String[] args) {
        BlockedSetExample ref = new BlockedSetExample();

        for (int k = 0; k < 5; k++) {
//            new Thread(new BlockedMethodCaller(ref, k)).start();
            new Thread(new BlockedMethodCaller(new BlockedSetExample(), k)).start();
        }
    }

    public synchronized void f(int x) throws InterruptedException {
        System.out.println("+" + x);
        Thread.sleep(1000);
        System.out.println("-" + x);
    }
}
