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


class Main {
    public static void main(String[] args) {
        Recruit recruit = new Recruit("22");
    }
}