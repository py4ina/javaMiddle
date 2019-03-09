package questions.multithreading.lessons;

public class Lab_Thread_Thread_Play_The_Accordion {
    public static void main(String[] args) throws InterruptedException {
        for (int k = 0; k < 10; k++){
            Runnable printerA = new PrintRunnable("A   .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();

            Runnable printerB = new PrintRunnable(".   B", 99);
            Thread threadB = new Thread(printerB);
            threadB.start();

            checker(threadA);
            checker(threadB);

            System.out.println("---------");
            Runnable printerC = new PrintRunnable(" C", 100);
            printerC.run();
            System.out.println("---------");
        }
    }

    private static void checker(Thread thread) throws InterruptedException {
        long before = System.currentTimeMillis();
        thread.join();
        long after = System.currentTimeMillis();
        System.out.println("resultA :" + (after - before));
    }
}
