package questions.io_strim;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        byte[] b = tmp.getBytes();

        ByteArrayInputStream stream1 = new ByteArrayInputStream(b);
        ByteArrayInputStream stream2 = new ByteArrayInputStream(b, 0, 5);

        for (int i = 0; i < 2; i++){
            int c;
            while ((c = stream2.read()) != -1) {
                if (i == 0){
                    System.out.print((char) c);
                } else {
                    System.out.print(Character.toUpperCase((char) c));
                }
                stream1.reset();
            }
        }
    }
}
