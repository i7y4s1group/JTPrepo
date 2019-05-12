public class Student
{
    protected int kodStudenta;
    protected String imie;
    protected String nazwisko;
    protected String nrIndeksu;

    public void ustawKodStudenta(int kodStudenta)
    {
        this.kodStudenta = kodStudenta;
    }

    public void ustawImie(String imie)
    {
        this.imie = imie;
    }

    public void ustawNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }

    public void ustawNrIndeksu(String nrIndeksu)
    {
        this.nrIndeksu = nrIndeksu;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "kodStudenta=" + kodStudenta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrIndeksu='" + nrIndeksu + '\'' +
                '}';
    }
}