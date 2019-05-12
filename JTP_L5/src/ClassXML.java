import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ClassXML implements Interfejs
{
    private Path target;

    @Override
    public void przetwarzanie(String sciezka)
    {
        System.out.println("Przetworzono plik XML.");
    }

    @Override
    public void przeniesienie(String sciezka)
    {
        File file = new File(sciezka);
        Path source = Paths.get(sciezka);
        target = Paths.get("D:/Studia/SEMESTR_4/Ania_materialy/JTP_L5/JTP_L5_test/XML/" + file.getName());
        try
        {
            Files.move(source, target, REPLACE_EXISTING);
            System.out.println("Przeniesiono plik XML.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
