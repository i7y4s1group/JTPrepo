package io.github.maciejlagowski.jtp.l5.zad2;

/**
 * @author Maciej Łagowski
 * L5 zadanie 2 (Dziedziczenie klas)
 */

public class Main {
    public static void main(String[] args) {
        StudentWCY student = new StudentWCY();
        student.setImie("Maciek");
        student.setNazwisko("Łagowski");
        student.setNumerIndeksu(69284);
        student.setGrupa("I7Y4S1");
        student.setWydzial("Cybernetyka");
        student.setNumerPorzadkowyStudentaNaWydziale(1234);
        System.out.println(student);
    }
}
