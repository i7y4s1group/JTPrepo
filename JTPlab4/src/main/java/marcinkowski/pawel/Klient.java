package marcinkowski.pawel;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Klient extends Thread{
    private Semaphore semaphore;
    private Random random = new Random();

    public Klient(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void zakupy(List<Produkt> listaProdoktow){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < random.nextInt(listaProdoktow.size()+1); i++) {
            int pom = random.nextInt(listaProdoktow.size());
            listaProdoktow.remove(pom);
        }
        semaphore.release();
    }
}
