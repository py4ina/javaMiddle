package com.learn.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class _1_ISTest_close_short {
    public static void main(String[] args) {
        String fileName = ".../home/vitalik/file0.txt";

        InputStream inFile = null;
        try {
            inFile = new FileInputStream(fileName);
            readFullyByByte(inFile);
            System.out.println("\n\n\n");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fileName != null){
                try {
                    inFile.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    private static void readFullyByByte(InputStream in) throws IOException {
        int oneByte;
        while ((oneByte = in.read()) != -1){
            System.out.println((char) oneByte);
        }
    }
}
