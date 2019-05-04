package com.learn.io._2_lesson;

import java.io.*;

public class _6_OSTest_different_buffers {
    private static final String FILE_FROM_NAME = "/home/vitalik/Pictures/java-json.jpg";
    private static final String FILE_TO_NAME = "/home/vitalik/Pictures/java-json-2.jpg";
    private static final int BUFFER_SIZE = 64 * 1024;

    public static void main(String[] args) throws IOException {
        for (int k = 1; k < BUFFER_SIZE; k *= 2) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream(FILE_FROM_NAME);
                out = new FileOutputStream(FILE_TO_NAME);
                long start = System.currentTimeMillis();
                copy(in, out, k);
                long stop = System.currentTimeMillis();
                System.out.println("Elapsed time = " + (stop - start) + ", k = " + k);
            } catch (IOException e){
                throw new IOException("Exception when copy from '"+FILE_FROM_NAME+"' to file '"+FILE_TO_NAME+"'", e);
            } finally {
                closeQuietly(in);
                closeAndFlushQuietly(out);
            }
        }
    }

    private static void copy(InputStream in, OutputStream out, int bufferSize) throws IOException {
        byte[] buff = new byte[bufferSize];
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
