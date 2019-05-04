package com.learn.io._2_lesson;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class _1_decorator_gzip {
    private static final String FILE_FROM_NAME = "/home/vitalik/Documents/Навчання/Docker/Использование_Docker_Эдриен_Моуэт.pdf";
    private static final String FILE_TO_NAME = "/home/vitalik/Documents/Навчання/Docker/book1.xxx";
    private static final int BUFFER_SIZE = 256;

    public static void main(String[] args) throws IOException {
        InputStream in = new SniffInputStream(new BufferedInputStream(
                new FileInputStream(FILE_FROM_NAME)));

        OutputStream out = new GZIPOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(FILE_TO_NAME)));

        int count;
        byte[] buff = new byte[BUFFER_SIZE];
        while ((count = in.read(buff)) != -1){
            out.write(buff, 0, count);
        }
    }
}
