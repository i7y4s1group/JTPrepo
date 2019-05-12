package anna.paszcza;

public class Finanse
{
    private boolean sprawdzBudzet;
    private int budzet;

    public Finanse(boolean sprawdzBudzet, int budzet)
    {
        this.sprawdzBudzet = sprawdzBudzet;
        this.budzet = budzet;
    }

    public void setSprawdzBudzet(boolean sprawdzBudzet)
    {
        this.sprawdzBudzet = sprawdzBudzet;
    }

    public boolean getSprawdzBudzet()
    {
        return sprawdzBudzet;
    }

    public void setBudzet(int budzet)
    {
        this.budzet = budzet;
    }

    public int getBudzet()
    {
        return budzet;
    }
}
