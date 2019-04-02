package questions.autoboxing;

public class AutoboxingTest {
    public static void main(String[] args) {
        sumBeforeInclusive(10);
    }

    public static void method(Integer[] i) {
        for (Integer number :i) {
            System.out.println(number);
        }
    }

    public static Integer sumBeforeInclusive(int number) {
        Integer iOb = number;
        if (number > 1) {
            System.out.println("number => "+number);
            iOb += sumBeforeInclusive(number - 1);
        }
        return iOb;
    }
}
