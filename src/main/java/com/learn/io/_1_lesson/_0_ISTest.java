package com.learn.io._1_lesson;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class _0_ISTest {
    public static void main(String[] args) throws IOException {
        InputStream inFile = new FileInputStream("/home/vitalik/file0.txt");
        readFullyByByte(inFile);
        System.out.println("\n\n\n");

        InputStream inUrl = new URL("https://www.google.com").openStream();
        readFullyByByte(inUrl);
        System.out.println("\n\n\n");

        InputStream inArray = new ByteArrayInputStream(new byte[]{65, 66, 67, 68, 69});
        readFullyByByte(inArray);
        System.out.println("\n\n\n");
    }

    private static void readFullyByByte(InputStream in) throws IOException {
        while (true){
            int oneByte = in.read();
            if (oneByte != -1){
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + "end");
                break;
            }
        }
    }
}