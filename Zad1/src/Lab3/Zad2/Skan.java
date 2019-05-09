package Lab3.Zad2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Skan{

    public void skanuj(String nazwa, String sciezka) throws Exception{
       File file = new File(sciezka);
       for(String nazwaPliku : file.list()){
           System.out.println(nazwaPliku);
           if(nazwaPliku.equals(nazwa)){
               zapis(file.getAbsolutePath()+nazwaPliku);
               return;
           }

       } throw new Exception();

    }

    public void zapis(String nazwa){
        try {
            FileWriter fileWriter = new FileWriter("log.txt");
            fileWriter.write(nazwa);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(nazwa);
        file.delete();
    }

    public void run(String nazwa, String sciezka){
        while(true){
            try {
                skanuj(nazwa, sciezka);
            } catch (Exception e) {
                try {
                    sleep(60000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

}
