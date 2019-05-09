package Lab2.Zad1;

public class Klient {
    private String imie;
    private String nazwisko;

    public Klient(String imione, String nazwisko) {
        this.imie = imione;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setImie(String imione) {
        this.imie = imione;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}