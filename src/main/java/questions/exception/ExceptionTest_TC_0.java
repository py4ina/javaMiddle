package questions.exception;

public class ExceptionTest_TC_0 {
    public static void main(String[] args) {
        System.out.println(f());

    }

    private static int f() {
        try {
            System.out.println(0);
            return 42;
        } finally {
            System.out.println(1);
            return 24;
        }
    }
}