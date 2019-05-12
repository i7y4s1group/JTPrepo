package anna.paszcza;

public class Produkt
{
    private int cena;
    private int marza;
    private String nazwa;
    private int ilosc;

    public Produkt(int cena, int marza, String nazwa, int ilosc)
    {
        this.cena = cena;
        this.marza = marza;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
    }

    public void setCena(int cena)
    {
        this.cena = cena;
    }

    public void setMarza(int marza)
    {
        this.marza = marza;
    }

    public void setNazwa(String nazwa)
    {
        this.nazwa = nazwa;
    }

    public void setIlosc(int ilosc)
    {
        this.ilosc = ilosc;
    }

    public int getCena()
    {
        return cena;
    }

    public int getMarza()
    {
        return marza;
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public int getIlosc()
    {
        return ilosc;
    }
}
