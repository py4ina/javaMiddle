package com.learn.io._3_lesson;

import java.io.*;

public class _2_Charset {
    private static final int BYTES = 256;
    private static final int BUFFER_SIZE = 16;

    public static void main(String[] args) throws UnsupportedOperationException, IOException {
        byte[] rawData = new byte[BYTES];
        for (int k = 0; k < BYTES; k++) {
            rawData[k] = (byte) (k - 128);
        }

        InputStream is = new ByteArrayInputStream(rawData);
        Reader reader = new InputStreamReader(is/*, "UTF-8"*/);

        char[] buff = new char[BUFFER_SIZE];
        int count;
        while ((count = reader.read(buff)) != -1){
            System.out.println(new String(buff, 0, count));
        }
    }
}
