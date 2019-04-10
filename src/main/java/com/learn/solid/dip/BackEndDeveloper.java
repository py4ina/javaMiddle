package com.learn.solid.dip;

public class BackEndDeveloper implements Developer {
    public void writeJava() {
        System.out.println("--->BackEndDeveloper.writeJava()");
    }

    @Override
    public void develop() {
        writeJava();
    }
}

