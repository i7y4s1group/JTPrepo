package Lab2.Zad1;

import java.util.*;

public class Klienci {
    private List<Klient> klienci;
    private int liczbaKlientow = 10;
    private int N = (int) (liczbaKlientow * 0.1);
    private NazwaKlienta nazwaKlienta;

    public Klienci(){
        nazwaKlienta = new NazwaKlienta();
        klienci = nazwaKlienta.stworz(liczbaKlientow);
    }

    public void dodaj(Klient klient){
        klienci.add(klient);
    }

    public void wyswietl(){
        klienci.forEach(klient -> System.out.println(klient));
    }

    public void usun(){
        int id;
        System.out.println("Usuń klienta o numerze: ");
        Scanner scan = new Scanner(System.in);
        id = Integer.parseInt(scan.nextLine());
        klienci.remove(id);
    }

    public void szukaj(String imie, String nazwisko){
        klienci.forEach(klient -> { if (imie == klient.getImie() && nazwisko == klient.getNazwisko())
            System.out.println("Istnieje");

        });
    }

    public void losujCoMiesiac(boolean jak){
        for (int i = 1; i < 13; i++) {
            System.out.println("-------" + i + "-------");
            if (jak) {
                losuj();
            }
            else{
                losujTylkoRaz();
            }
        }

    }

    public List<Klient> losujTylkoRaz(){
        List<Klient> rabat = new ArrayList<>();
        Klient klientRabat;
        for (int i = 0; i < N; i++) {
            klientRabat = klienci.get((int) (Math.random() * 100));
            if(rabat.contains(klientRabat) == false)
            rabat.add(klientRabat);
        }
        rabat.forEach(klient -> System.out.println(klient));
        return rabat;
    }

    public List<Klient> losuj() {
        List<Klient> rabat = new ArrayList<>();
        Klient klientRabat;
        for (int i = 0; i < N; i++) {
            klientRabat = klienci.get((int) (Math.random() * 100));
            rabat.add(klientRabat);
        }
        rabat.forEach(klient -> System.out.println(klient));
        return rabat;
    }

    public Map<String, Integer> wystapieniaImion(){
        Map<String, Integer> wystapienia = new HashMap<>();
        for(Klient klient : klienci){
            Integer ilosc = wystapienia.get(klient.getImie());
            if(ilosc == null) ilosc = 1;
            else ilosc++;
            wystapienia.put(klient.getImie(), ilosc);
        }
        return wystapienia;
    }

}
