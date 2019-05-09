package Lab3.Zad1;
public class MyException extends Exception {
    private String wiadomosc;

    public MyException(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }
}
