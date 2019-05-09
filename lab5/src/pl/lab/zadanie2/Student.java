package pl.lab.zadanie2;

public class Student extends StudentWCY {
    private String imie;
    private String nazwisko;
    private int numerIndeksu;

    Student(String imie, String nazwisko, int numerIndeksu){
        setImie(imie);
        setNazwisko(nazwisko);
        setNumerIndeksu(numerIndeksu);
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNumerIndeksu(int numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }
}
