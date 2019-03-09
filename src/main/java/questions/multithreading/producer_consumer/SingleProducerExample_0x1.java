package questions.multithreading.producer_consumer;

public class SingleProducerExample_0x1 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Consumer(buffer)).start();
    }
}
