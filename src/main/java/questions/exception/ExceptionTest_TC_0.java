package questions.exception;

public class ExceptionTest_TC_0 {
    public static void main(String[] args) {
        try {
            System.out.println(0);
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println(1);
            throw e;
        } catch (ArithmeticException e){
            System.out.println(2);
        }

        System.out.println(3);
    }
}