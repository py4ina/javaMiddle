package com.learn.io._2_lesson;

import java.io.IOException;
import java.io.InputStream;

public class SniffInputStream extends InputStream {
    private final InputStream delegee;

    public SniffInputStream(InputStream delegee) {
        this.delegee = delegee;
    }

    @Override
    public int read() throws IOException {
        System.out.println("read 1 byte");
        return this.delegee.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        int read = this.delegee.read(b);
        System.out.println("read "+read+" byte");
        return read;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read = this.delegee.read(b, off, len);
        System.out.println("read "+read+" byte");
        return read;
    }
}
