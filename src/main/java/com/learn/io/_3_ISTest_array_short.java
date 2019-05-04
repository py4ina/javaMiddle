package com.learn.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class _3_ISTest_array_short {
    public static void main(String[] args) {
        String fileName = "/home/vitalik/file0.txt";

        InputStream inFile = null;
        try {
            inFile = new FileInputStream(fileName);
            readFullyByArray(inFile);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("");
        } finally {
            closeQuietly(inFile);
        }
    }

    private static void readFullyByArray(InputStream in) throws IOException {
        byte[] buff = new byte[5];
        int count;
        while ((count = in.read(buff)) != -1){
            System.out.print(new String(buff, 0, count, "UTF-8"));
        }
    }

    private static void closeQuietly(InputStream inFile){
        if (inFile != null){
            try {
                inFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}