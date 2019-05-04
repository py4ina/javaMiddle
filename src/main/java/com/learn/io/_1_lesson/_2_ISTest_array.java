package com.learn.io._1_lesson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.apache.tomcat.util.http.fileupload.IOUtils.closeQuietly;

public class _2_ISTest_array {
    public static void main(String[] args) {
        String fileName = "/home/vitalik/file0.txt";

        InputStream inFile = null;
        try {
            inFile = new FileInputStream(fileName);
            readFullyByArray(inFile);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            closeQuietly(inFile);
        }
    }

    private static void readFullyByArray(InputStream in) throws IOException {
        byte[] buff = new byte[5];

        while (true){
            int count = in.read(buff);

            if (count != -1){
                System.out.println("count = " + count
                        + ", buff = " + Arrays.toString(buff)
                        + ", str = " + new String(buff, 0, count, "UTF-8"));
            } else {
                break;
            }
        }
    }
}