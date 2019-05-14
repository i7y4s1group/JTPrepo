package io.github.maciejlagowski.jtp.l5.zad2;

class StudentWCY extends StudentWAT {
    private int numerPorzadkowyStudentaNaWydziale;

    int getNumerPorzadkowyStudentaNaWydziale() {
        return numerPorzadkowyStudentaNaWydziale;
    }

    void setNumerPorzadkowyStudentaNaWydziale(int numerPorzadkowyStudentaNaWydziale) {
        this.numerPorzadkowyStudentaNaWydziale = numerPorzadkowyStudentaNaWydziale;
    }

    @Override
    public String toString() {
        return "StudentWCY{" + getImie() + " " + getNazwisko() + " " +
                getNumerIndeksu() + " " + getGrupa() + " " + getWydzial() +
                " " + getNumerPorzadkowyStudentaNaWydziale() + "}";
    }
}
