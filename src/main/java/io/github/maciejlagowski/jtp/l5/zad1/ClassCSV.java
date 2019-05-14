package io.github.maciejlagowski.jtp.l5.zad1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@AllArgsConstructor
@Data
class ClassCSV implements FileSupportInterface {

    private String fileLocation;

    public void processFile() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileLocation));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            System.out.println("Processing CSV file...");
            for (CSVRecord csvRecord : csvParser) {
                System.out.println(csvRecord);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void moveFile(String locationToMove) {
        try {
            FileUtils.moveFile(new File(fileLocation), new File(locationToMove));
            System.out.println("CSV File moved");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
