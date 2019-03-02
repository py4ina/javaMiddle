package questions.oop;

import java.util.Arrays;

import static java.util.Collections.shuffle;

public class Main2 {
    public static void main(String[] args) throws CloneNotSupportedException {
//        B b = new B(1);
//        A a = new A();
//        Class<? extends A> aClass = a.getClass();
//        System.out.println(b.getClass());
//        System.out.println(aClass);
        Object[] things = new Object[]{"Hi mum", new Integer(42), /* and a whole bunch more */};
        shuffle(Arrays.asList(things));
        Class cls = things[0].getClass();
        System.out.println(cls);
    }
}

class A{

}


class B extends A{
    private int a;

    public B(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}