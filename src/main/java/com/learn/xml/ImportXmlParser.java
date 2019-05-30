package com.learn.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ImportXmlParser {
    private static final String PATH = "/src/main/resources/learnFiles/import.XML";


    public static void main(String[] args) {
        try {
            String rootPath = System.getProperty("user.dir") + PATH;
            File inputFile = new File(rootPath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("OP");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Id : " + eElement.getAttribute("Id"));

                    NodeList carNameList = eElement.getElementsByTagName("ICCID");
//
                    for (int count = 0; count < carNameList.getLength(); count++) {
                        Node node1 = carNameList.item(count);
                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element range = (Element) node1;
                            System.out.println(range.getTextContent());
//                            System.out.println("BATCH : " + range.getAttribute("BATCH"));
//                            System.out.println("FIRST-ICCID : " + range.getAttribute("FIRST-ICCID"));
//                            System.out.println("LAST-ICCID : " + range.getAttribute("LAST-ICCID"));
//                            System.out.println("------------");
                        }
                    }
//                    NodeList carNameList2 = eElement.getElementsByTagName("ICCID");
//                    System.out.println(carNameList2);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
