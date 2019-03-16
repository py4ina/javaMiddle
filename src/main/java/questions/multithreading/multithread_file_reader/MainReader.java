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

        String fileName = "/home/vitalik/Documents/UkrPol/DNA/45188393/45188393_DNAGD_01078.LBB";
        String fileName2 = "/home/vitalik/Documents/UkrPol/DNA/45188393/45188393_DNAGD_01079.LBB";
        String fileName3 = "/home/vitalik/Documents/UkrPol/DNA/45188393/45188393_DNAGD_01080.LBB";

        files.add(fileName);
        files.add(fileName2);
        files.add(fileName3);

        for (String name : files) {
            List<String> list = new ArrayList<>();
            Thread thread = new Thread(() -> {
                System.out.println(name);
                list.addAll(fileReader(fileName));
            });
            thread.start();
            System.out.println("finish -> " + name);
            thread.sleep(1000);
            thread.join();
            map.put(name, list);
        }
//        Runtime runtime = Runtime.getRuntime();
//        long memory = runtime.totalMemory() - runtime.freeMemory();
//        System.out.println(memory);
        System.out.println("1");
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
//        thread.sleep(1000);
        thread.join();
        map.put(fileName, list);
        System.out.println("Finish");
        return map;
    }
}
