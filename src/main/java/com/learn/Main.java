package com.learn;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Main {

    private static final String PATH = "/src/main/resources/learnFiles/input.xml";


    public static void main(String[] args) {
        try {
            String rootPath = System.getProperty("user.dir") + PATH;
            File inputFile = new File(rootPath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("supercars");
            System.out.println("----------------------------");
//
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.print("company : ");
                    System.out.println(eElement.getAttribute("company"));
                    NodeList carNameList = eElement.getElementsByTagName("carname");

                    for (int count = 0; count < carNameList.getLength(); count++) {
                        Node node1 = carNameList.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element car = (Element) node1;
                            System.out.print("car name : ");
                            System.out.println(car.getTextContent());
                            System.out.print("car type : ");
                            System.out.println(car.getAttribute("type"));
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}