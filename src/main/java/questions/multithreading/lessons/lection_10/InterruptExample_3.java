package questions.multithreading.lessons.lection_10;

public class InterruptExample_3 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        try {
            Object o = new Object();
            synchronized (o){
                o.wait();
            }
        } catch (InterruptedException e){
            System.out.println("Interrupted by exception");
        }
    }
}