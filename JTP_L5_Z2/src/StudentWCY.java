public class StudentWCY extends StudentWAT
{
    protected int nrWydzialu;
    protected int numerPorzadkowyStudentaNaWydziale;

    public void ustawNrWydzialu(int nrWydzialu)
    {
        this.nrWydzialu = nrWydzialu;
    }

    public void ustawNumerPorzadkowyStudentaNaWydziale(int numerPorzadkowyStudentaNaWydziale)
    {
        this.numerPorzadkowyStudentaNaWydziale = numerPorzadkowyStudentaNaWydziale;
    }

    @Override
    public String toString()
    {
        return "StudentWCY{" +
                "nrWydzialu=" + nrWydzialu +
                ", numerPorzadkowyStudentaNaWydziale=" + numerPorzadkowyStudentaNaWydziale +
                ", grupa='" + grupa + '\'' +
                ", wydzial='" + wydzial + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrIndeksu='" + nrIndeksu + '\'' +
                '}';
    }
}