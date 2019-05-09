package Lab3.Zad1;
public class MyException3 extends Exception {
    private String wiadomosc;

    public MyException3(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }
}
