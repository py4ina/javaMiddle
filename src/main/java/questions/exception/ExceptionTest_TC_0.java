package questions.exception;

public class ExceptionTest_TC_0 {
    public static void main(String[] args) {
        try {
            System.out.println(0);
            throw new RuntimeException();
        } catch (NullPointerException e) {
            System.out.println(1);
        }

        System.out.println(2);
    }
}