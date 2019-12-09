package com.learn.WAGU_data_in_table_view.examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File dir = new File("/home/vitalik/");
                dir.mkdirs();
        File file = new File(dir, "filename.txt");
        FileWriter archivo = new FileWriter(file);
        archivo.write(String.format("%20s %20s %20s %20s %20s %20s \r\n", "column 1", "column 2", "column 1", "column 2", "column 1", "column 2"));
        archivo.write(String.format("%20s %20s %20s %20s %20s %20s \r\n", "column 1", "column 2", "column 1", "column 2", "column 1", "colu"));
        archivo.flush();
        archivo.close();
    }
}
