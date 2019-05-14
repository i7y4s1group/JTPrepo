package io.github.maciejlagowski.jtp.l5.zad1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

@AllArgsConstructor
@Data
public class ClassXML implements FileSupportInterface {

    private String fileLocation;

    public void processFile() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileLocation));
            NodeList nList = doc.getElementsByTagName("staff");
            System.out.println("Processing XML File...");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.print("Id : " + eElement.getAttribute("id") + ", ");
                    System.out.print("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent() + ", ");
                    System.out.print("Account Number : " + eElement.getElementsByTagName("accountNumber").item(0).getTextContent() + ", ");
                    System.out.print("Value : " + eElement.getElementsByTagName("value").item(0).getTextContent() + ", ");
                    System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveFile(String locationToMove) {
        try {
            FileUtils.moveFile(new File(fileLocation), new File(locationToMove));
            System.out.println("XML File moved");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
