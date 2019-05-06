package com.learn.io._3_lesson;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class _1_Charset {
    private static final int BYTES = 256;

    public static void main(String[] args) throws UnsupportedOperationException, UnsupportedEncodingException {
        byte[] rawData = new byte[BYTES];
        for (int k = 0; k < BYTES; k++) {
            rawData[k] = (byte) (k - 128);
        }

        for (String name: Charset.availableCharsets().keySet()){
            System.out.println(new String(rawData, name));
            System.out.println("\n\n\n");
        }
    }
}
