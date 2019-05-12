package Zadanie2;

public class Student {
    protected String name;
    protected String surname;
    protected String indexNumber;
    protected String code;

    public Student() {
    }

    public Student(String name, String surname, String indexNumber, String code) {
        this.name = name;
        this.surname = surname;
        this.indexNumber = indexNumber;
        this.code = code;
    }

    public void studentName(String name){
        this.name = name;
    }

    public void studentSurname(String surname){
        this.surname = surname;
    }

    public void studentIndexNumber(String indexNumber){
        this.indexNumber = indexNumber;
    }

    public void studentsCode(String code){
        this.code = code;
    }
}
