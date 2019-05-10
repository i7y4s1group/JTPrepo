package los.przemyslaw;

import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Klient extends Thread {
    private Semaphore semaphore;
    private Magazyn magazyn;
    private Random rand = new Random();

    public Klient(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void zakup(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < rand.nextInt(magazyn.wezStanMagazynu().size()); i++) {
            int randomInt = rand.nextInt(magazyn.wezStanMagazynu().size());
            int randInt2 = rand.nextInt(magazyn.wezStanMagazynu().get(randomInt).getIlosc());
            magazyn.zmniejszZapasy(randInt2,randomInt);
        }
        semaphore.release();
    }
}
