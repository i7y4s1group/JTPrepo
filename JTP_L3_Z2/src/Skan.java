import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Skan
{
    private File directory = new File("D:/test");
    private File[] file;
    private String plik = "plik.txt";

    public Skan()
    {
    }

    public void skanuj() throws Wyjatek
    {
        if(directory.exists())
        {
            if(directory.canExecute() && directory.canRead() && directory.canWrite())
            {
                file = directory.listFiles();
                for(int i=0; i<file.length; i++)
                {
                    if(file[i].getName().equals(plik))
                    {
                        File log = new File("log.txt");
                        if(log.exists())
                        {
                            try (FileWriter writer = new FileWriter("log.txt", true))
                            {
                                writer.append(file[i] + System.getProperty("line.separator"));
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            file[i].delete();
                            System.out.println("Usunieto plik");
                        }
                        else
                        {
                            throw new Wyjatek("Log nie istnieje");
                        }
                    }
                    else
                    {
                        if(i == file.length - 1)
                        {
                            throw new Wyjatek("Nie znaleziono pliku");
                        }
                    }
                }
            }
            else
            {
                throw new Wyjatek("Brak uprawnien");
            }
        }
        else
        {
            throw new Wyjatek("Folder nie istnieje");
        }
    }
}
