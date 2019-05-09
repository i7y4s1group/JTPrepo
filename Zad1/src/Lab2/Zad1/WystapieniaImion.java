package Lab2.Zad1;

public class WystapieniaImion {
    private String imie;
    private int wystapienia = 0;

    public WystapieniaImion(String imie, int wystapienia) {
        this.imie = imie;
        this.wystapienia = wystapienia;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getWystapienia() {
        return wystapienia;
    }

    public void setWystapienia(int wystapienia) {
        this.wystapienia = wystapienia;
    }
}
