package questions;

public class Main {
    static int MAX;
    static int MIN;

    static {
        MAX = 100;
        MIN = 0;
    }

    public Main() {

    }

    public static void main(String[] args) {
        System.out.println(MAX);
        System.out.println(MIN);
    }
}

interface A {
    void a();
}

class B implements A {

    public void a() {

    }
}
