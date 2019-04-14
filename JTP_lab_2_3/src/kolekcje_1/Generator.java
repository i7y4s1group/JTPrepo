package kolekcje_1;

import java.util.Random;

public class Generator {
    static private char surnamePrefix = (char) 64;
    static private int iter = 1;
    static private Random rand = new Random();
    static private String[] names = {"Adam", "Bartosz", "Cezary", "Damian", "Eryk",
                                     "Franciszek", "Grzegorz", "Henryk", "Igor", "Jaroslaw"};

    public static String nextName() {
        return names[rand.nextInt(10)];
    }

    public static String nextSurname() {
        String tmp = "";
        surnamePrefix++;
        if((int) surnamePrefix == 91)
            surnamePrefix = 'A';
        for(int i = 0; i < iter; i++) {
            tmp += surnamePrefix;
        }
        if(surnamePrefix == 'Z')
            iter++;
        return (tmp + "abacki");
    }

}
