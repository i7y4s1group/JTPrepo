package Zadanie1.files;

import Zadanie1.exceptions.MyFileException;
import Zadanie1.validators.Validator;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CSVFile implements FileHandling {

    private File file;
    private Validator validator;

    public CSVFile(File file, Validator validator) {
        this.file = file;
        this.validator = validator;
    }

    @Override
    public void fileProccesing() {
        System.out.println("Processing CSV file " + file.getName());
    }

    @Override
    public void fileTransfer() throws MyFileException {

        validator.validateDirectory(new File("D:\\WAT_PROGRAMY\\JTP_lab_5\\src\\Zadanie1\\Relocation"));
        if(validator.hasErrors()){
            throw new MyFileException("Directory Relocation doesnt exist");
        }

        validator.validateDirectory(new File("D:\\WAT_PROGRAMY\\JTP_lab_5\\src\\Zadanie1\\Relocation\\CSV\\"));
        if(validator.hasErrors()){
            throw new MyFileException("Directory CSV doesnt exist");
        }

        File destinationFile = new File("D:\\WAT_PROGRAMY\\JTP_lab_5\\src\\Zadanie1\\Relocation\\CSV\\" + file.getName());

        try {
            FileUtils.moveFile(file, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
