package com.learn.io._3_lesson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class _3_Charset {
    private static final int BUFFER_SIZE = 16;

    public static void main(String[] args) throws IOException {
        InputStream is = null;
        try {
            is = new URL("http://lenta.ru").openStream();
            Reader reader = new InputStreamReader(is, "windows-1251");

            char[] buff = new char[BUFFER_SIZE];
            int count;
            while ((count = reader.read(buff)) != -1){
                System.out.println(new String(buff, 0, count));
            }
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
