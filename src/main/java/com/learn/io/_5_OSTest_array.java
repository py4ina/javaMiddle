package com.learn.io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class _5_OSTest_array {
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
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buff = new byte[5];
        int count;
        while ((count = in.read(buff)) != -1){
            out.write(buff, 0, count);
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
