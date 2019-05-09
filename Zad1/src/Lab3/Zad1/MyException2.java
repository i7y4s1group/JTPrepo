package Lab3.Zad1;
public class MyException2 extends Exception {
    private String wiadomosc;

    public MyException2(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }
}
