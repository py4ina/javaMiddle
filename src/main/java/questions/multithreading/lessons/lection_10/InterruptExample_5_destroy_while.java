package questions.multithreading.lessons.lection_10;

public class InterruptExample_5_destroy_while {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    System.out.println("Hello!");
                    for (long k = 0; k < 1_000_000_000L; k++);
                }
            }
        });
        thread.start();
        Thread.sleep(3000);
        thread.suspend();
        Thread.sleep(3000);
        thread.resume();
    }
}