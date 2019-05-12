public class Main
{
    public static void main(String[] args)
    {
        Student student = new Student();
        StudentWAT studentWAT = new StudentWAT();
        StudentWCY studentWCY = new StudentWCY();

        student.ustawImie("Adam");
        student.ustawNazwisko("Kowalski");
        student.ustawKodStudenta(1);
        student.ustawNrIndeksu("1");

        studentWAT.ustawImie("Adam");
        studentWAT.ustawNazwisko("Kowalski");
        studentWAT.ustawKodStudenta(1);
        studentWAT.ustawNrIndeksu("1");
        studentWAT.ustawGrupe("I7Y4S1");
        studentWAT.ustawWydzial("Cybernetyki");

        studentWCY.ustawImie("Adam");
        studentWCY.ustawNazwisko("Kowalski");
        studentWCY.ustawKodStudenta(1);
        studentWCY.ustawNrIndeksu("1");
        studentWCY.ustawGrupe("I7Y4S1");
        studentWCY.ustawWydzial("Cybernetyki");
        studentWCY.ustawNrWydzialu(1);
        studentWCY.ustawNumerPorzadkowyStudentaNaWydziale(1);

        System.out.println(student.toString());
        System.out.println(studentWAT.toString());
        System.out.println(studentWCY.toString());

        //public - jest dostep do wszystkich pol, ale mozna sie odwolywac po kropce np przy wypisywaniu
        //protected - jest dostep do pol poprzez metody, nie mozna sie odwolywac po kropce, ale np StudentWAR w metodzie toString moze uzyc pola Imie z klasy Student
        //private - nie ma dostepu do pol np StudentWAT nie moze nadpisac nr indeksu, w metodzie toString nie mozna uzyc pol z klasy Student
    }
}
