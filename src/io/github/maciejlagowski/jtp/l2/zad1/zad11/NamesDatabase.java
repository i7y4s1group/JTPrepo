package io.github.maciejlagowski.jtp.l2.zad1.zad11;

import java.util.Random;

class NamesDatabase {

    private static int surnameIterator = 0;

    private static String[] forenames = {"Adam", "Bartosz", "Cezary", "Damian", "Elżbieta", "Franciszek", "Gabriela", "Henryk", "Irena", "Janusz",
            "Kamil", "Ludmiła", "Maciej", "Norbert", "Patryk", "Rafał", "Sławomir", "Tomasz", "Urszula", "Wojciech"};

    static String[] getRandomName() {
        String[] name = new String[2];
        Random random = new Random();
        name[0] = forenames[random.nextInt(forenames.length)];
        name[1] = getSurname();
        return name;
    }

    private static String getSurname() {
        String surname = "abacki";
        StringBuilder stringBuilder = new StringBuilder();
        char character = (char) ('A' + (surnameIterator % 26));
        for (int i = 0; i <= (surnameIterator / 26); i++) {
            stringBuilder.append(character);
        }
        surname = stringBuilder + surname;
        surnameIterator++;
        return surname;
    }
}
