package io.github.maciejlagowski.jtp.labka4;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

class CsvClass {
    //Variables
    private Writer writer;
    private CSVPrinter csvPrinter;
    private Logger logger = LoggerClass.getLogger();

    //Methods
    CsvClass(int clientId) throws IOException {
        String csvPath = "client" + clientId + ".csv";
        writer = new FileWriter(csvPath);
        csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
    }

    void printCsv(String whatToPrint) {
        try {
            csvPrinter.printRecord(whatToPrint);
            csvPrinter.flush();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    static List<Product> makeObjectsFromCsv() {
        List<Product> productList = new LinkedList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/products.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get(0);
                String description = csvRecord.get(1);
                Double price = Double.parseDouble(csvRecord.get(2));
                Double margin = Double.parseDouble(csvRecord.get(3));
                productList.add(new Product(name, description, price, margin));
            }
        } catch (IOException ex) {
            Logger logger = LoggerClass.getLogger();
            logger.error(ex.getMessage());
        }
        return productList;
    }
}
