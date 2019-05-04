package com.learn.io._2_lesson;

import java.io.*;

public class _0_decorator_buffered {
    private static final String FILE_FROM_NAME = "/home/vitalik/Pictures/java-json.jpg";
    private static final String FILE_TO_NAME = "/home/vitalik/Pictures/java-json-2.jpg";
    private static final int BUFFER_SIZE = 256;
    private static final int ITERATION_SIZE = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        for (int k = 1; k < ITERATION_SIZE; k *= 2) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(
                        new FileInputStream(FILE_FROM_NAME), k);
                out = new BufferedOutputStream(
                        new FileOutputStream(FILE_TO_NAME), k);

                iterationsTime(k, in, out);
            } catch (IOException e){
                throw new IOException("Exception when copy from '"+FILE_FROM_NAME+"' to file '"+FILE_TO_NAME+"'", e);
            } finally {
                closeQuietly(in);
                closeAndFlushQuietly(out);
            }
        }
    }

    private static void iterationsTime(int k, InputStream in, OutputStream out) throws IOException {
        long start = System.currentTimeMillis();
        copy0(in, out);
        long stop = System.currentTimeMillis();
        System.out.println("Elapsed time = " + (stop - start) + ", k = " + k);
    }

    private static void copy(InputStream in, OutputStream out, int bufferSize) throws IOException {
        byte[] buff = new byte[bufferSize];
        int count;
        while ((count = in.read(buff)) != -1){
            out.write(buff, 0, count);
        }
    }

    private static void copy0(InputStream in, OutputStream out) throws IOException {
        int oneByte;
        while ((oneByte = in.read()) != -1){
            out.write(oneByte);
        }
    }

    private static void copy1(InputStream in, OutputStream out) throws IOException {
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
