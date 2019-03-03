package questions.multithreading;

import lombok.AllArgsConstructor;

public class ThreadExample_0 {
    public static void main(String[] args) throws InterruptedException {
        Runnable printer = new PrintRunnable(" B", 1000);
        Thread thread = new Thread(printer);
        thread.start();

        for (int k = 0; k < 10; k++){
            Thread.sleep(250);
            System.out.println("A");
        }

        System.out.println("Start wait");
        thread.join();
        System.out.println("Finish");
    }
}

@AllArgsConstructor
class PrintRunnable implements Runnable{
    private String msg;
    private long sleepMillis;

    @Override
    public void run() {
        for (int k = 0; k < 10; k++){
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(msg);
        }
    }
}
