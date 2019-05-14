package io.github.maciejlagowski.jtp.l5.zad2;

class StudentWAT extends Student {
    private String grupa;
    private String wydzial;

    String getGrupa() {
        return grupa;
    }

    void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    String getWydzial() {
        return wydzial;
    }

    void setWydzial(String wydzial) {
        this.wydzial = wydzial;
    }

    @Override
    void setNumerIndeksu(int numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }
}
