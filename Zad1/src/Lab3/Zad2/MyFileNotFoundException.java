package Lab3.Zad2;

import java.io.FileNotFoundException;

public class MyFileNotFoundException extends FileNotFoundException {

    private String wiadomosc;

    public MyFileNotFoundException(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }
}
