package questions.io_strim;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args){
        String source = "Hibernate offers a series of tools for developers to use in their tool chain. " +
                "The most prominent being Hibernate Tools which is a set of Eclipse plugins and part of " +
                "JBoss Tools. But there is more";
        byte[] buf = source.getBytes();

        try(FileOutputStream f = new FileOutputStream("file0.txt")) {

            for (int i = 0; i < buf.length; i += 2){
                f.write(buf[i]);
            }
            f.write(buf);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
