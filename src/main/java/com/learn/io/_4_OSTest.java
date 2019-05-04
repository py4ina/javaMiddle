package com.learn.io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class _4_OSTest {
    public static void main(String[] args) throws IOException {
        String fileName = "/home/vitalik/file0.txt";

        InputStream inFile = null;
        try {
            inFile = new FileInputStream(fileName);
            byte[] data = readFullyByByte(inFile);
            System.out.println(new String(data, "UTF-8"));
        } catch (IOException e){
            throw new IOException("Exception when open and read file " + fileName, e);
        } finally {
            closeQuietly(inFile);
        }
    }

    private static byte[] readFullyByByte(InputStream in) throws IOException {
        int oneByte;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((oneByte = in.read()) != -1){
            out.write(oneByte);
        }
        return out.toByteArray();
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