package los.przemyslaw;
import java.util.ArrayList;

public class Magazyn {
    private ArrayList<Produkt> list = new ArrayList<Produkt>();

    public void dodajProdukt(Produkt produkt)
    {
        list.add(produkt);
    }
    public void uzupelnijZapasy(int ilosc, int indeks)
    {
        list.get(indeks).setIlosc(list.get(indeks).getIlosc() + ilosc);
    }

    public void zmniejszZapasy(int ilosc, int indeks)
    {
        list.get(indeks).setIlosc(list.get(indeks).getIlosc() - ilosc);
    }

    public ArrayList<Produkt> wezStanMagazynu()
    {
        return list;
    }

}
