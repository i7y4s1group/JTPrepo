import java.io.FileNotFoundException;

public class Wyjatek extends FileNotFoundException
{
    public Wyjatek()
    {

    }

    public Wyjatek(String message)
    {
        super(message);
    }
}
