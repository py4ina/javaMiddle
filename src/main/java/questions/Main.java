package questions;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        int min = 1001;
        int max = 2000;
        int iteration = 0;


        Path path = Paths.get("file0.txt");

//Use try-with-resource to get auto-closeable writer instance
        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            for (; min <= max; min++ ){
                iteration++;
                writer.write("000000000000000" + min + "\n");
            }
//            writer.write("Hello World !!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
