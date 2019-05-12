package Zadanie1.exceptions;

import java.io.FileNotFoundException;

public class MyFileException extends FileNotFoundException {
    private String message;
    private String reason;

    public MyFileException(){}

    public MyFileException(String message) {
        this.message = message;
    }

    public MyFileException(String message, String reason){
        this.message = message;
        this.reason = reason;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
