package Blok2.Zadanie2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Validator {
    private Map<String, String> errors;

    public Validator() {
        errors = new HashMap<>();
    }

    public boolean hasErrors(){
        return !errors.isEmpty();
    }

    public void validateDirectory(File directory){

        if (!directory.canRead()){
            errors.put("directory-read", "cannot be read");
        }

        if(!directory.isDirectory()){
            errors.put("directory", "is not directory");
        }
    }

    public void validateFile(File file){

        if(!file.canRead()){
            errors.put("file-read", "cannot be read");
        }

        if(!file.canExecute()){
            errors.put("file-execute", "cannot be executed");
        }
    }

    public void clearErrors(){
        errors.clear();
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
