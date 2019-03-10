package questions.multithreading.rologistic;

public class Waiter implements Runnable {
    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg){
            try {
                System.out.println(name + " ждем вызов метода notify: " + System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " был вызов метода notify: " + System.currentTimeMillis());
            // обработаем наше сообщение
            System.out.println(name + " : " + msg.getMsg());
        }
    }
}
