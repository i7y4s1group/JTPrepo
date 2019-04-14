package kolekcje_1;

public class MyPair {
    private String name;
    private int number;

    public MyPair(String newName, int newNumber) {
        name = newName;
        number = newNumber;
    }

    public String getName() {
        return name;
    }

    public void incrementNumber() {
        number++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
