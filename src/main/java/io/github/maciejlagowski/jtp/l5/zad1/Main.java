package io.github.maciejlagowski.jtp.l5.zad1;

public class Main {
    public static void main(String[] args) {
        FileSupport fileSupport = new FileSupport();

        //CSV
        fileSupport.set(new ClassCSV("src/main/resources/myCSVFile.csv"));
        fileSupport.processFile();
        fileSupport.moveFile("moved/myCSVFile.csv");


        //XML
        fileSupport.set(new ClassXML("src/main/resources/myXMLFile.xml"));
        fileSupport.processFile();
        fileSupport.moveFile("moved/myXMLFile.xml");

        //TXT
        fileSupport.set(new ClassTXT("src/main/resources/myTXTFile.txt"));
        fileSupport.processFile();
        fileSupport.moveFile("moved/myTXTFile.txt");
    }
}
