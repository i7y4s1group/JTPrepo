package Lab2.Zad1;

import java.util.ArrayList;
import java.util.List;

public class NazwaKlienta {
    private String imiona[] = {"Andrzej", "Borys", "Cezary", "Daniel", "Stanislaw", "Franek", "Grzegorz", "Jan", "Paweł", "Mateusz"};

    public List<Klient> stworz(int ile){
        List<Klient> klienci = new ArrayList<>();
        String imie;
        String nazwisko;
        Klient klient;

        for (int i = 0; i < ile; i++) {
            imie = imiona[(int) (Math.random() * 10)];

            char x = 'A';
            int y = x + i % 26;
            x = (char)y;
            String s = String.valueOf(x);
            nazwisko = s + "abacki";


            klient = new Klient(imie, nazwisko);

            klienci.add(klient);
        }

        return klienci;
    }
}

