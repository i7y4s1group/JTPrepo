package io.github.maciejlagowski.jtp.l5.zad1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@AllArgsConstructor
@Data
public class ClassTXT implements FileSupportInterface {

    private String fileLocation;

    public void processFile() {
        System.out.println("Processing TXT File...");
        try {
            List<String> allLines = Files.readAllLines(Paths.get(fileLocation));
            for(String line : allLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void moveFile(String locationToMove) {
        try {
            FileUtils.moveFile(new File(fileLocation), new File(locationToMove));
            System.out.println("TXT File moved");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
