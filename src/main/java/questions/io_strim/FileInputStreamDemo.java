package questions.io_strim;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;

        try (FileInputStream fileInputStream = new FileInputStream("/home/vitalik/qwerty.txt")){
            System.out.println("fileInputStream.available() : " + (size = fileInputStream.available()));
            int n = size / 40;
            System.out.println("n = " + n);
            for (int i = 0; i < n; i++) {
                System.out.println((char) fileInputStream.read());
            }
            System.out.println("fileInputStream.available() : " + (fileInputStream.available()));

            byte[] b = new byte[n];
            System.out.println(new String(b, 0, n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
