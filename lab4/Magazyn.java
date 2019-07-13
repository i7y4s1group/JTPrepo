import java.util.*;

public class Magazyn {
    public List<Produkt> produkty = new ArrayList<Produkt>();

    public void dodajPozycje(String nazwa, float cena, float marza)
    {
        Produkt produkt = new Produkt(nazwa, cena, marza);
        System.out.println("dodajPozycje -> Dodano pozycje: nazwa=" + nazwa + " cena=" + cena + " marza=" + marza);
        produkty.add(produkt);
    }

    public void usunPozycje(String nazwa, int ilosc)
    {
        int usunieto = 0;

        if(ilosc < this.iloscPozycji(nazwa))
        {
            System.out.println("usunPozycje -> Brakuje produktu na stanie: " + nazwa);
            return;
        }

        for (Produkt p : produkty)
        {
            if (p.nazwa.compareTo(nazwa) == 0)
            {
                produkty.remove(p);
                System.out.println("usunPozycje -> Usunieto pozycje: " + nazwa);

                usunieto++;

                if(ilosc < usunieto)
                {
                    return;
                }
            }
        }

        System.out.println("usunProdukt -> Nie znaleziono produktu " + nazwa + " w liscie produktow");
    }

    public int iloscPozycji(String nazwa)
    {
        int ilosc = 0;

        for (Produkt p : produkty)
        {
            if (p.nazwa.compareTo(nazwa) == 0)
            {
                ilosc++;
            }
        }

        System.out.println("iloscPozycji -> " + nazwa + " = " + ilosc);

        return ilosc;
    }

    public int iloscProduktow()
    {
        List<String> produktyWykluczone = listaProduktow();

        return produktyWykluczone.size();
    }

    public List<String> listaProduktow()
    {
        List<String> produktyWykluczone = new ArrayList<String>();
        int ilosc = 0;
        boolean znaleziony = false;

        for (Produkt p : produkty)
        {
            znaleziony = false;

            for (String pw : produktyWykluczone)
            {
                if(pw.compareTo(p.nazwa) == 0)
                {
                    znaleziony = true;
                    break;
                }
            }

            if(!znaleziony)
            {
                produktyWykluczone.add(p.nazwa);
            }
        }

        return produktyWykluczone;
    }
}
