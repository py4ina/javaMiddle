package questions.multithreading.lessons;

import lombok.AllArgsConstructor;

public class ThreadExample_0 {
    public static void main(String[] args) throws InterruptedException {
       final Thread mainThread = Thread.currentThread();
       Thread runThread = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   System.out.println("Run: wait for main!");
                   mainThread.join();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });
       runThread.start();

       System.out.println("Main: wait for main!");
       runThread.join();
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
