public class StudentWAT extends Student {
    protected String group;
    protected String department;

    public void studentGroup(String group){
        this.group = group;
    }

    public void studentFaculty(String department){
        this.department = department;
    }
}
