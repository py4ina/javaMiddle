package questions.io_strim;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class FileInputStreamDemo {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("file0.txt");
             FileInputStream fileInputStream2 = new FileInputStream("file1.txt")){

            List<Character> strings0 = new LinkedList<>();
            List<Character> strings1 = new LinkedList<>();
            streamPrinter(fileInputStream, strings0);
            streamPrinter(fileInputStream2, strings1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void streamPrinter(FileInputStream fileInputStream, List<Character> listChar) throws IOException {
        int i;
        while ((i = fileInputStream.read()) != -1){
            char symbol = (char) i;
            System.out.print(symbol);
            listChar.add(symbol);
        }
        System.out.println("--------------------------------------");
        System.out.println(listChar);
    }
}
