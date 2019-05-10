package los.przemyslaw;

public class Produkt {
    private String nazwa;
    private double cena;
    private double marza;
    private int ilosc;

    public Produkt(String nazwa, double cena, double marza, int ilosc) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.marza = marza;
        this.ilosc = ilosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public double getMarza() {
        return marza;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setMarza(double marza) {
        this.marza = marza;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    public String toString(){
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", marza=" + marza +
                ", ilosc ='" + ilosc + '\'' +
                '}';
    }
}
