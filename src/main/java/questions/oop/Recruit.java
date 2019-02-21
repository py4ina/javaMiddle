package questions.oop;

public class Recruit {
    private int age;

    public Recruit(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("age < 0. age = " + age);
        }
        this.age = age;
        System.out.println("Recruit("+age+")");
    }

    public Recruit() {
        this(18);
        System.out.println("Recruit()");
    }

    public Recruit(String string) {
        this(convertToInt(string));
        System.out.println("Recruit(\"" + string + "\")");
    }

    private static int convertToInt(String string) {
        System.out.println("convertToInt(\"" + string + "\")");
        return Integer.parseInt(string);
    }
}

class DefFieldValue {
    private int i = 1;
    private double d = 1.5;
    private boolean b = calcBoolean();

    private boolean calcBoolean() {
        System.out.println("calcBoolean()");
        return false;
    }

    private Object object = new Object();
    private int[] arr = {0, 1, 2};

    public DefFieldValue() {
        System.out.println("i = " + i);
        System.out.println("d = " + d);
        System.out.println("b = " + b);
        System.out.println("object = " + object);
        System.out.println("arr = " + arr);
    }
}

class Main {
    public static void main(String[] args) {
        DefFieldValue defFieldValue = new DefFieldValue();
    }
}