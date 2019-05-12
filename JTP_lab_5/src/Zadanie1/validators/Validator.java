package Zadanie1.validators;

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
        clearErrors();

        if(!directory.exists()){
            errors.put("directory_exist", "directory doesnt exist: " + directory.getName());
        }

        if (!directory.canRead()){
            errors.put("directory_read", "cannot be read: " + directory.getName());
        }

        if(!directory.isDirectory()){
            errors.put("directory", "is not directory" + directory.getName());
        }
    }

    public void validateFile(File file){
        clearErrors();

        if(!file.canRead()){
            errors.put("file", "cannot be read");
        }

        if(!file.canExecute()){
            errors.put("file", "cannot be executed");
        }
    }

    public void clearErrors(){
        errors.clear();
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
