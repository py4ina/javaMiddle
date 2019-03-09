package questions.multithreading.producer_consumer;

public class SingleProducerExample_1x1 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1, 1000, buffer)).start();
//        new Thread(new Producer(500, 1000, buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
