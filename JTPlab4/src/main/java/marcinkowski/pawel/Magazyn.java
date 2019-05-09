package marcinkowski.pawel;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Magazyn {
    private List<Produkt> listaProdoktow = new ArrayList<Produkt>();
    private List<Produkt> produkty = new ArrayList<Produkt>();
    private Random random = new Random();

    private int i = 1;

    public List<Produkt> getListaProdoktow() {
        return listaProdoktow;
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void wczytajMagazyn() throws FileNotFoundException {
        Scanner odczyt = new Scanner(new File("C:\\Users\\Paweł\\IdeaProjects\\JTPlab4\\src\\main\\java\\marcinkowski\\pawel\\magazyn.txt"));
        while (odczyt.hasNext()) {
            String linia = odczyt.nextLine();
            String[] elementy = linia.split(";");
            Produkt produkt = new Produkt(elementy[1], Double.parseDouble(elementy[2]), Double.parseDouble(elementy[3]), elementy[4]);
            listaProdoktow.add(produkt);
            produkty.add(produkt);
        }

        System.out.println(listaProdoktow);

    }

    public boolean stanMagazynu(){
        if(listaProdoktow.isEmpty()) return false;
        return true;
    }

}
