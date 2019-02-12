package questions.collections;

public class GenericsLesson {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        f(a);
//        f(b);
    }

    public static void f(A arg) {
        System.out.println(arg.getName());
    }
}

class A {
    String getName() {
        return "A";
    }
}

class B {
    String getName() {
        return "B";
    }
}