package io.github.maciejlagowski.jtp.l5.zad2;

class Student {
    private String imie;
    private String nazwisko;
    protected int numerIndeksu;

    String getImie() {
        return imie;
    }

    void setImie(String imie) {
        this.imie = imie;
    }

    String getNazwisko() {
        return nazwisko;
    }

    void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    int getNumerIndeksu() {
        return numerIndeksu;
    }

    void setNumerIndeksu(int numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }
}
