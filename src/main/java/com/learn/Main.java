package com.learn;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Map<String, String> map = main.readFile();
        System.out.println(map);
    }

    private final static String PATH = "/etc/hostname";
    private Path path = Paths.get(PATH);

    public  Map<String, String> readFile() {
        Map<String, String> source = null;
        try {
            source = fileParser(Files.readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return source;
    }

    private Map<String, String> fileParser(List<String> strings){
        if (strings.size() > 1){
            throw new UnsupportedOperationException();
        }
        Map<String, String> map = new HashMap<>();
        for (String line : strings){
            String value = line.replaceAll("[^0-9?!\\.]","");
            map.put("terminal_id", value);
        }
        return map;
    }
}
