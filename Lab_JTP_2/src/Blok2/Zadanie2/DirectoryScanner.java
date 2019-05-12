package Blok2.Zadanie2;

import java.io.File;
import java.util.Arrays;

public class DirectoryScanner {
    private Validator validator;
    private File directory;
    private LogFile logFile;
    private String directoryPath;

    public DirectoryScanner(String directoryPath, String logFileName) {
        this.directoryPath = directoryPath;
        this.directory = new File(directoryPath);
        this.logFile = new LogFile(logFileName);
        this.validator = new Validator();
    }

    public void eraseFilesFromDirectory() throws MyFileException {
        File[] files = directory.listFiles();

        chceckFiles(files);
        checkDirectory();

        if(validator.hasErrors()){
            throw new MyFileException("DirectoryScanner - problem with files or directory");
        }

        if(getNumbersOfFiles() <= 0){
            throw new MyFileException("DirectoryScanner - no files in directory");
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()){
                logFile.addInformation(files[i].getAbsolutePath());
                logFile.addInformation(System.getProperty("line.separator"));
                files[i].delete();
            }
        }
    }

    public Long getNumbersOfFiles(){
        File[] files = directory.listFiles();

        return Arrays
                .stream(files)
                .filter(file -> file.isFile())
                .count();
    }

    private void checkDirectory(){
        validator.validateDirectory(directory);
    }

    private void chceckFiles(File[] files){
        for (int i = 0; i < files.length; i++) {
            validator.validateFile(files[i]);
        }
    }

    public void showErrors(){
        if(validator.hasErrors()){
            validator
                    .getErrors()
                    .entrySet()
                    .forEach(error -> System.out.println(error.getKey() + " " + error.getValue()));
        }
    }

    public void closeLogFile(){
        logFile.closeLogFile();
    }
}
