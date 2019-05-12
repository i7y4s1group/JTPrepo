package Blok2.Zadanie2;

import java.io.FileWriter;
import java.io.IOException;

public class LogFile {
    private String fileName;
    private FileWriter fileWriter;

    public LogFile(String fileName) {
        this.fileName = fileName;
        createLogFile();
    }

    private void createLogFile(){
        try {
            fileWriter = new FileWriter(fileName, true);
        } catch (IOException e) {
            System.err.println("CANNOT CREATE LOG FILE");
            e.printStackTrace();
        }
    }

    public void addInformation(String message){
        try {
            fileWriter.append(message);
        } catch (IOException e) {
            System.err.println("CANNOT ADD MESSAGE TO LOG FILE");
            e.printStackTrace();
        }
    }

    public void closeLogFile(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("CANNOT CLOSE LOG FILE");
            e.printStackTrace();
        }
    }
}
