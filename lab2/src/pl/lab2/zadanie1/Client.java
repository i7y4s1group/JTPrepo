package pl.lab2.zadanie1;

public class Client {
    private String name;
    private String surname;
    private boolean selected;

    Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.selected=false;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public boolean isSelected(){
        return selected;
    }

    public void deselect(){
        selected=false;
    }
}
