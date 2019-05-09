public class Client {
    private String name;
    private String surname;
    private boolean check;

    public Client(String newName, String newSurname) {
        name = newName;
        surname = newSurname;
        check = false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isCheck() {
        return check;
    }

    public String toString() {
        return name + " " + surname;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }
}
