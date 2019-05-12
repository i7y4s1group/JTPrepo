package Blok2.Zadanie2;

import java.io.FileNotFoundException;

public class MyFileException extends FileNotFoundException {
    private String message;

    public MyFileException(String wiadomosc){
        this.message = wiadomosc;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
