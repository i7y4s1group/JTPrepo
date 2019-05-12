import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class Sprawdzanie
{
    private KontekstStrategii kontekstStrategii;
    private Weryfikator weryfikator = new Weryfikator();

    public String sprawdzRozszerzenie(String sciezka)
    {
        return FilenameUtils.getExtension(sciezka);
    }

    public void dzialanie(String sciezka)
    {
        if(weryfikator.sprawdzFolder(sciezka))
        {
            File folder = new File(sciezka);
            File[] pliki = folder.listFiles();
            for(int i=0; i<pliki.length; i++)
            {
                if(weryfikator.sprawdzPlik(pliki[i].getAbsolutePath()))
                {
                    if (sprawdzRozszerzenie(pliki[i].getAbsolutePath()).equals("csv"))
                    {
                        ClassCSV classCSV = new ClassCSV();
                        kontekstStrategii = new KontekstStrategii(classCSV);
                        kontekstStrategii.przetworz(pliki[i].getAbsolutePath());
                        kontekstStrategii.przenies(pliki[i].getAbsolutePath());
                    }

                    if (sprawdzRozszerzenie(pliki[i].getAbsolutePath()).equals("xml"))
                    {
                        ClassXML classXML = new ClassXML();
                        kontekstStrategii = new KontekstStrategii(classXML);
                        kontekstStrategii.przetworz(pliki[i].getAbsolutePath());
                        kontekstStrategii.przenies(pliki[i].getAbsolutePath());
                    }

                    if (sprawdzRozszerzenie(pliki[i].getAbsolutePath()).equals("txt"))
                    {
                        ClassTXT classTXT = new ClassTXT();
                        kontekstStrategii = new KontekstStrategii(classTXT);
                        kontekstStrategii.przetworz(pliki[i].getAbsolutePath());
                        kontekstStrategii.przenies(pliki[i].getAbsolutePath());
                    }
                }
            }
        }
    }
}
