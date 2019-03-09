package questions.multithreading.producer_consumer;

public class SingleProducerExample_1x0 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1, 1000, buffer)).start();
    }
}
