package anna.paszcza;

import org.apache.log4j.Logger;
import java.util.Random;
import java.util.concurrent.Semaphore;


public class Klient extends Thread
{
    private static Logger log = Logger.getLogger(Klient.class);
    private int id;
    private Magazyn magazyn;
    private Random random = new Random();
    private Semaphore semafor;
    private Finanse finanse;

    public Klient(Magazyn magazyn, Semaphore semafor, int id, Finanse finanse)
    {
        this.magazyn = magazyn;
        this.semafor = semafor;
        this.finanse = finanse;
        this.id = id;
    }

    @Override
    public void run()
    {
        int ilosc;
        int produkt;
        while(finanse.getSprawdzBudzet())
        {
            try
            {
                semafor.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            produkt = random.nextInt(magazyn.getIloscStanMagazynu());
            if(!finanse.getSprawdzBudzet())
            {
                semafor.release();
                break;
            }
            else
            {
                ilosc = random.nextInt(magazyn.getStanMagazynu().get(produkt).getIlosc()-2)+3;
                log.info(id + " KUPUJE: " + magazyn.getStanMagazynu().get(produkt).getNazwa() + " " + ilosc);
                System.out.println(id + " KUPUJE: " + magazyn.getStanMagazynu().get(produkt).getNazwa() + " " + ilosc);
                magazyn.usunProdukt(ilosc, produkt);
                try
                {
                    sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                semafor.release();

            }
        }
    }
}