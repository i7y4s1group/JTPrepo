package Blok1.Zadanie1;

import java.util.Objects;

public class NameCounter {
    private String name;
    private int counter = 0;

    public NameCounter() {
    }

    public NameCounter(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void count(){
        counter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameCounter that = (NameCounter) o;
        return counter == that.counter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter);
    }
}
