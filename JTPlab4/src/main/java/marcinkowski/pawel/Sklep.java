package marcinkowski.pawel;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Sklep {
    private int liczbaKlientow;
    private int budzetFirmy;
    private Random random = new Random();
    private Log log = new Log();

    public Sklep(int liczbaKlientow, int budzetFirmy) {
        this.liczbaKlientow = liczbaKlientow;
        this.budzetFirmy = budzetFirmy;
    }

    public void prowadzenieSklepu() throws FileNotFoundException {
        Magazyn magazyn = new Magazyn();
        magazyn.wczytajMagazyn();
        int pom = random.nextInt( magazyn.getProdukty().size() - 1);
        while(!magazyn.getListaProdoktow().isEmpty()) {
            for (int i = 0; i < liczbaKlientow; i++) {


                    if (magazyn.getListaProdoktow().size() > 10 && magazyn.getListaProdoktow().size() < 30  && magazyn.getProdukty().get(pom).getCena() < budzetFirmy) {
                        while(magazyn.getProdukty().get(pom).getCena() < budzetFirmy) {
                        magazyn.getListaProdoktow().add(magazyn.getProdukty().get(pom));
                        budzetFirmy -= pom;
                    }
                }

                Klient klient = new Klient(new Semaphore(1));
                klient.zakupy(magazyn.getListaProdoktow());
                System.out.println(magazyn.getListaProdoktow());
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.Klienci();
        }
    }
}
