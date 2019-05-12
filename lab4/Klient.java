import java.util.*;

public class Klient extends Thread {
    public String imie;
    public String nazwisko;

    Synch synch;

    Klient(String imie, String nazwisko, Synch synch)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.synch = synch;
    }

    public void run()
    {
        int iloscWylosowanychProduktow;
        int wylosowanyProdukt;
        int iloscWylosowanychPozycji;

        while(true) {
            try {
                Thread.sleep(5000 * (synch.rand.nextInt(5) + 1));
                synch.semaphore.acquire();

                iloscWylosowanychProduktow = 3 + synch.rand.nextInt(synch.magazyn.iloscProduktow() - 3);

                for(int i = 0; i < iloscWylosowanychProduktow; i++)
                {
                    wylosowanyProdukt = synch.rand.nextInt(synch.magazyn.iloscProduktow());
                    iloscWylosowanychPozycji = synch.rand.nextInt(synch.magazyn.iloscPozycji(synch.magazyn.produkty.get(wylosowanyProdukt).nazwa));
                    synch.magazyn.usunPozycje(synch.magazyn.produkty.get(wylosowanyProdukt).nazwa, iloscWylosowanychPozycji);
                }

                synch.semaphore.release();
            } catch (InterruptedException e)
            {

            }
        }
    }
}
