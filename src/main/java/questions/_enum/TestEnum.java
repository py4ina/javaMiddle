package questions._enum;

import java.util.concurrent.atomic.AtomicInteger;

public enum TestEnum {
    ADMIN,
    BUYER
}


class T{
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10_000; j++) {
            new Thread(() -> atomicInteger.incrementAndGet()).start();
        }

        Thread.sleep(2000);
        System.out.println(atomicInteger);
    }
}

