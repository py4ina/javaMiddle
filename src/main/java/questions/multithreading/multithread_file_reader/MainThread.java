package questions.multithreading.multithread_file_reader;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
       Object ref = new Object();

       synchronized (ref){
           ref.wait();
       }
    }
}
