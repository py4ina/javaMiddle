package com.learn.io._1_lesson;

import java.io.*;

public class _6_OSTest_array_close {
    private static final String FILE_FROM_NAME = "/home/vitalik/Pictures/java-json.jpg";
    private static final String FILE_TO_NAME = "/home/vitalik/Pictures/java-json-2.jpg";
    private static final int BUFFER_SIZE = 64 * 1024;


    public static void main(String[] args) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(FILE_FROM_NAME);
            out = new FileOutputStream(FILE_TO_NAME);
            copy(in, out);
        } catch (IOException e){
            throw new IOException("Exception when copy from '"+FILE_FROM_NAME+"' to file '"+FILE_TO_NAME+"'", e);
        } finally {
            closeQuietly(in);
            closeAndFlushQuietly(out);
        }
    }

    private static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buff = new byte[BUFFER_SIZE];
        int count;
        while ((count = in.read(buff)) != -1){
            out.write(buff, 0, count);
        }
    }

    private static void closeQuietly(InputStream in){
        if (in != null){
            try {
                in.close();
            } catch (IOException ignore) {}
        }
    }

    private static void closeAndFlushQuietly(OutputStream out) {
        if (out != null) {
            try {
                out.flush();
            } catch (IOException ignore) {}
            try {
                out.close();
            } catch (IOException ignore) {}
        }
    }
}