package questions.multithreading.multithread_file_reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MainReader {
    public static void main(String[] args) throws InterruptedException {
        Map<String, List<String>> map = new HashMap<>();
        List<String> files = new ArrayList<>();

        String fileName = "/home/py4ina/Downloads/Test/VodafoneTestPOP.txt";
        String fileName2 = "/home/py4ina/Downloads/Test/VodafoneTest.txt";
        String fileName3 = "/home/py4ina/Downloads/Test/VodafoneTestPOP2.txt";

        files.add(fileName);
        files.add(fileName2);
        files.add(fileName3);

        for (String name : files) {
//            map.putAll(readNewFile(name, map));

            List<String> list = new ArrayList<>();
            Thread thread = new Thread(() -> list.addAll(fileReader(name)));

            thread.start();

            synchronized (thread){
                thread.wait();
            }
            thread.join();
            map.put(name, list);
        }
        System.out.println("ttt");
    }



    private static List<String> fileReader(String fileName) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> list.add(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static Map<String, List<String>> readNewFile(String fileName, Map<String, List<String>> map)
            throws InterruptedException {
        System.out.println("Start");
        List<String> list = new ArrayList<>();

        Thread thread = new Thread(() -> {
            System.out.println(fileName);
            list.addAll(fileReader(fileName));
        });
        thread.start();
        thread.join();

        map.put(fileName, list);
        System.out.println("Finish");
        return map;
    }
}
