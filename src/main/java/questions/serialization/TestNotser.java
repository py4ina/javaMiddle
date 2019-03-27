package questions.serialization;

public class TestNotser {
    public static void main(String[] args) {
        byte[] raw = SerUtils.objToByte(new Notser());
    }
}
