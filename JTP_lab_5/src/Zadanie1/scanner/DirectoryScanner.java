package Zadanie1.scanner;

import Zadanie1.files.StrategyContext;
import Zadanie1.exceptions.MyFileException;
import Zadanie1.files.*;
import Zadanie1.validators.Validator;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class DirectoryScanner {
    private Validator validator;
    private File directory;
    private StrategyContext strategyContext;
    private String directoryPath;

    public DirectoryScanner(String directoryPath) {
        this.directoryPath = directoryPath;
        this.directory = new File(directoryPath);
        this.validator = new Validator();
    }

    public void startFileProcessing() throws MyFileException {
        FileHandling fileHandling;
        File[] files = directory.listFiles();

        for (int i = 0; i < files.length; i++) {
            fileHandling = getFileExtension(files[i]);

            validator.validateFile(files[i]);
            if(validator.hasErrors()){
                throw new MyFileException("Problem with file: " + files[i].getName());
            }

            if(fileHandling != null) {
                strategyContext = new StrategyContext(fileHandling);
                strategyContext.fileProccesing();
                strategyContext.fileTransfer();
            }
        }
    }

    private FileHandling getFileExtension(File file){
        switch (FilenameUtils.getExtension(file.getName())){
            case "csv": return new CSVFile(file, validator);
            case "txt": return new TXTFile(file, validator);
            case "xml": return new XMLFile(file, validator);
            default: return null;
        }
    }
}
