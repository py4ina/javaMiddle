public class Main {
    public static void main(String[] args) throws IllegalArgumentException, IllegalArgumentException {
        sqr(2);
    }

    public static double sqr(double arg) {

        throw new RuntimeException();
    }

}

 class Formatter {
    public String format(String value) {
        return "["+value+"]";
    }
}

class TestNPE {
    public static String handle(Formatter f, String s) {
        if("".equals(s)) {
            return "(none)";
        }
        return f.format(s.trim());
    }
}