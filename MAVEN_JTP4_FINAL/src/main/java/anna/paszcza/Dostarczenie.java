package anna.paszcza;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.concurrent.Semaphore;

public class Dostarczenie extends Thread
{
    private Magazyn magazyn;
    private Finanse finanse;
    private Semaphore semafor;
    private static Logger log = Logger.getLogger(Dostarczenie.class);
    private File file = new File("D:/Studia/SEMESTR_4/Ania_materialy/MAVEN_JTP4_FINAL/plik.csv");

    public Dostarczenie(Magazyn magazyn, Finanse finanse, Semaphore semafor)
    {
        this.magazyn = magazyn;
        this.finanse = finanse;
        this.semafor = semafor;
    }

    public void run()
    {
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
            dostarcz();
            semafor.release();
        }
    }

    public void dostarcz()
    {
        BufferedReader bufReader = null;
        String line;
        if(file.exists())
        {
            try (FileReader reader = new FileReader("D:/Studia/SEMESTR_4/Ania_materialy/MAVEN_JTP4_FINAL/plik.csv"))
            {
                bufReader = new BufferedReader(reader);
                try
                {
                    line = bufReader.readLine();
                    String[] wiersz = line.split(",");
                    int produkt = Integer.parseInt(wiersz[0]);
                    int ilosc = Integer.parseInt(wiersz[3]);
                    int cena = Integer.parseInt(wiersz[2]);
                    String nazwa = wiersz[1];

                    if (ilosc * cena > this.finanse.getBudzet())
                    {
                        System.out.println("BRAK FUNDUSZY NA ZAMOWIENIE");
                        log.warn("BRAK FUNDUSZY NA ZAMOWIENIE");
                        file.delete();
                        setSprawdzBudzet();
                    }
                    else
                    {
                        System.out.println("DOSTARCZAM: " + nazwa + " " + ilosc);
                        log.info("  DOSTARCZAM: " + nazwa + " " + ilosc);
                        setBudzet(ilosc * cena);
                        magazyn.dodajProdukt(ilosc, produkt);
                    }

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            file.delete();
        }
    }

    public void setSprawdzBudzet()
    {
        this.finanse.setSprawdzBudzet(false);
    }
    public void setBudzet(int cena)
    {
        this.finanse.setBudzet(this.finanse.getBudzet() - cena);
    }
}
