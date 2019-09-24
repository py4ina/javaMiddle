package com.learn;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    private static final String PATH = "/src/main/resources/learnFiles/input.xml";


    public static void main(String ... args) {
        A a = new B();
        a.print();
    }
}

abstract class A{
    public abstract void print();
}
class B extends A{
    public void print(){
        System.out.println("B");
    }
}

abstract class C extends B {
    public void print(){
        System.out.println("С");
    }
}