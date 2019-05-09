package marcinkowski.pawel;

public class Produkt {
    private String nazwa;
    private double cena;
    private double marza;
    private String opis;

    public Produkt(String nazwa, double cena, double marza, String opis) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.marza = marza;
        this.opis = opis;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getMarza() {
        return marza;
    }

    public void setMarza(double marza) {
        this.marza = marza;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", marza=" + marza +
                ", opis='" + opis + '\'' +
                '}';
    }

    public static class ProduktBuilder{
        private String nazwa;
        private double cena;
        private double marza;
        private String opis;

        public ProduktBuilder setNazwa(String nazwa){
            this.nazwa = nazwa;
            return this;
        }

        public ProduktBuilder setCena(double cena){
            this.cena = cena;
            return this;
        }

        public ProduktBuilder setMarza(double marza){
            this.marza = marza;
            return this;
        }

        public ProduktBuilder setOpis(String opis){
            this.opis = opis;
            return this;
        }

        public Produkt build(){
            return new Produkt(nazwa, cena, marza, opis);
        }
    }
}
