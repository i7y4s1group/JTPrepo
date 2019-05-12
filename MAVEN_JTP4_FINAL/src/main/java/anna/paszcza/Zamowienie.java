package anna.paszcza;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.File;
import java.util.concurrent.Semaphore;

public class Zamowienie extends Thread
{
    private Magazyn magazyn;
    private Finanse finanse;
    private Random random = new Random();
    private String aktualnyFolder = System.getProperty("user.dir");
    private String sciezkaPlikuCSV = aktualnyFolder + "/plik.csv";
    private File plik = new File(sciezkaPlikuCSV);
    private static Logger log = Logger.getLogger(Zamowienie.class);
    private Semaphore semafor;

    public Zamowienie(Magazyn magazyn, Finanse finanse, Semaphore semafor)
    {
        this.magazyn = magazyn;
        this.finanse = finanse;
        this.semafor = semafor;
    }

    @Override
    public void run()
    {
        while(finanse.getSprawdzBudzet())
        {
            for(int i=0; i<magazyn.getStanMagazynu().size(); i++)
            {
                if(magazyn.getStanMagazynu().get(i).getIlosc() < magazyn.getL())
                {
                    zamow(i);
                }

                if(!finanse.getSprawdzBudzet())
                {
                    break;
                }
            }
        }
    }

    public void zamow(int produkt)
    {
        int ilosc = random.nextInt(20)+10;
        try
        {
            semafor.acquire();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        stworzZamowienie(produkt, ilosc);
        semafor.release();
        try
        {
            sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void stworzZamowienie(int produkt, int ilosc)
    {
        try
        {
            plik.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(sciezkaPlikuCSV, false))
        {
            writer.write(produkt + "," + magazyn.getStanMagazynu().get(produkt).getNazwa() + "," + magazyn.getStanMagazynu().get(produkt).getCena() + "," + ilosc);
            System.out.println("ZAMAWIAM: " + magazyn.getStanMagazynu().get(produkt).getNazwa()  + " " + ilosc);
            log.info("  ZAMAWIAM: " + magazyn.getStanMagazynu().get(produkt).getNazwa()  + " " + ilosc);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
