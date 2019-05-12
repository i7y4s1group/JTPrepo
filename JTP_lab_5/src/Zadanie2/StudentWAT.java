package Zadanie2;

public class StudentWAT extends Student{
    protected String group;
    protected String faculty;

    public void studentGroup(String group){
        this.group = group;
    }

    public void studentFaculty(String faculty){
        this.faculty = faculty;
    }


    //private -> nie da się ustawić pola z klasy nadrzednej
    //protected i public -> da się ustawić pola klasy nadrzędnej
    /*
    @Override
    public void studentIndexNumber(String indexNumber){

    }*/

}
