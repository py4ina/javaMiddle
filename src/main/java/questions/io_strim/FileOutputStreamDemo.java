package questions.io_strim;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args){
        String source = "Hibernate offers a series of tools for developers to use in their tool chain. " +
                "The most prominent being Hibernate Tools which is a set of Eclipse plugins and part of " +
                "JBoss Tools. But there is more";
        byte[] buf = source.getBytes();

        try(FileOutputStream f0 = new FileOutputStream("file0.txt");
            FileOutputStream f1 = new FileOutputStream("file1.txt");
            FileOutputStream f2 = new FileOutputStream("file2.txt")) {

            for (int i = 0; i < buf.length; i += 2){
                f0.write(buf[i]);
            }
            f1.write(buf);
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
