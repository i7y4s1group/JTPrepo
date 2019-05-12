import java.io.File;

public class Weryfikator
{

    public boolean sprawdzPlik(String sciezka)
    {
        File plik = new File(sciezka);

        if(!plik.exists())
        {
            return false;
        }

        if(!plik.isFile())
        {
            return false;
        }

        if(!plik.canRead())
        {
            return false;
        }

        if(!plik.canExecute())
        {
            return false;
        }

        return true;
    }

    public boolean sprawdzFolder(String sciezka)
    {
        File folder = new File(sciezka);

        if(!folder.exists())
        {
            return false;
        }

        if(!folder.isDirectory())
        {
            return false;
        }

        if(!folder.canRead())
        {
            return false;
        }

        if(!folder.canExecute())
        {
            return false;
        }

        return true;
    }
}
