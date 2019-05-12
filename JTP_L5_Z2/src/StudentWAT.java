public class StudentWAT extends Student
{
    protected String grupa;
    protected String wydzial;

    public void ustawGrupe(String grupa)
    {
        this.grupa = grupa;
    }

    public void ustawWydzial(String wydzial)
    {
        this.wydzial = wydzial;
    }

    public void ustawNrIndeksu(String nrIndeksu)
    {
        this.nrIndeksu = nrIndeksu;
    }

    @Override
    public String toString()
    {
        return "StudentWAT{" +
                "grupa='" + grupa + '\'' +
                ", wydzial='" + wydzial + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrIndeksu='" + nrIndeksu + '\'' +
                '}';
    }
}