package kolekcje_1;

public class Client {
    private String name;
    private String surname;

    public Client(String newName, String newSurname) {
        name = newName;
        surname = newSurname;
    }

    public String toString() {
        return name + " " + surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
