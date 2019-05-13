public class Student {
    protected String name;
    protected String surname;
    protected String indexNumber;

    public Student(String name, String surname, String indexNumber) {
        this.name = name;
        this.surname = surname;
        this.indexNumber = indexNumber;
    }
    public Student() {
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
}
