package com.learn.xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
import java.util.*;

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

            NodeList nList = doc.getElementsByTagName("OP");

            List<String> hatFields = Arrays.asList("CLIENTE", "OV");

            Map<String, String> hatMap = new HashMap<>();
            Node opNode = nList.item(0);
            if (opNode.getNodeType() == opNode.ELEMENT_NODE) {
                Element element = (Element) opNode;
                hatMap.put("OP", element.getAttribute("Id"));
            }

            XMLInfo xmlInfo = new XMLInfo();
            xmlInfo.setRanges(new ArrayList<>());

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Id : " + eElement.getAttribute("Id"));

                    NodeList rangeList = eElement.getElementsByTagName("RANGE");
                    List<Range> rangesInner = new ArrayList<>();
                    for (int count = 0; count < rangeList.getLength(); count++) {
                        Node node = rangeList.item(count);
                        if (node.getNodeType() == node.ELEMENT_NODE) {
                            Element rangeElement = (Element) node;
                            rangesInner.add(Range.builder()
                                    .batch(rangeElement.getAttribute("BATCH"))
                                    .firstIcc(Long.valueOf(rangeElement.getAttribute("FIRST-ICCID")))
                                    .lastIcc(Long.valueOf(rangeElement.getAttribute("LAST-ICCID")))
                                    .build());
                        }
                    }
                    xmlInfo.setRanges(rangesInner);

                    for (String elementHat : hatFields) {
                        NodeList clientList = eElement.getElementsByTagName(elementHat);
                        Node clientNode = clientList.item(0);
                        if (clientNode.getNodeType() == clientNode.ELEMENT_NODE) {
                            Element element = (Element) clientNode;
                            hatMap.put(elementHat, element.getAttribute("Id"));
                        }
                    }
                    xmlInfo.setHat(hatMap);

                    List<IccId> lines = new ArrayList<>();
                    NodeList iccidList = eElement.getElementsByTagName("ICCID");
                    for (int count = 0; count < iccidList.getLength(); count++) {
                        Node node1 = iccidList.item(count);
                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element range = (Element) node1;
                            String line = range.getTextContent();
                            String[] rows = line.split("\\+");
                            long iccShort = Long.parseLong(rows[0].substring(9));

                            IccId iccId = IccId.builder()
                                    .line(line)
                                    .iccShort(iccShort)
                                    .build();

                            for (Range rangeInner : xmlInfo.getRanges()) {
                                if (iccShort >= rangeInner.getFirstIcc() && iccShort <= rangeInner.getLastIcc()){
                                    iccId.setBatch(rangeInner.getBatch());
                                }
                            }
                            lines.add(iccId);
                        }
                    }
                    xmlInfo.setLines(lines);
                }
            }


            System.out.println(xmlInfo);

            List<String> lines = getLines(xmlInfo);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getLines(XMLInfo xmlInfo) {
        List<String> lines = new ArrayList<>();
        xmlInfo.getHat().forEach((key, val) -> {
            lines.add(key + ": " + val);
        });
        lines.add("Start Data");
        xmlInfo.getLines().forEach(line -> lines.add(line.getLine() + "+" + line.getBatch()));
        return lines;
    }
}

@Data
class XMLInfo{
    private List<Range> ranges;
    private Map<String, String> hat;
    private List<IccId> lines;
}

@Data
@Builder
class Range{
    private String batch;
    private long firstIcc;
    private long lastIcc;
}

@Data
@Builder
class IccId{
    private String line;
    private long iccShort;
    private String batch;
}