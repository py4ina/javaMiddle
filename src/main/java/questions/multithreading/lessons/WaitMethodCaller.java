package questions.multithreading.lessons;

public class WaitMethodCaller implements Runnable {
    private final WaitSetExample ref;
    private final int k;

    public WaitMethodCaller(WaitSetExample ref, int k) {
        this.ref = ref;
        this.k = k;
    }

    @Override
    public void run() {
        try {
            ref.f(k);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
