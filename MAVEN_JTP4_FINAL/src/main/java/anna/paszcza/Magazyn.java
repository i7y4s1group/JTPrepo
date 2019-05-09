package anna.paszcza;

import java.util.ArrayList;
import java.util.List;

public class Magazyn
{
    private List<Produkt> stanMagazynu = new ArrayList<>();
    private int L = 10;

    public void dodajProdukt(int ilosc, int produkt)
    {
        stanMagazynu.get(produkt).setIlosc(stanMagazynu.get(produkt).getIlosc() + ilosc);
    }

    public void usunProdukt(int ilosc, int produkt)
    {
        stanMagazynu.get(produkt).setIlosc(stanMagazynu.get(produkt).getIlosc() - ilosc);
    }

    public void dodajNowyProdukt(Produkt produkt)
    {
        stanMagazynu.add(produkt);
    }

    public List<Produkt> getStanMagazynu()
    {
        return stanMagazynu;
    }

    public int getIloscStanMagazynu()
    {
        return stanMagazynu.size();
    }

    public void setStanMagazynu(List<Produkt> stanMagazynu)
    {
        this.stanMagazynu = stanMagazynu;
    }

    public int getL()
    {
        return L;
    }
}
