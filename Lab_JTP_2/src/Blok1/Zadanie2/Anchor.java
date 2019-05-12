package Blok1.Zadanie2;

import java.util.Objects;

public class Anchor {
    private Element first;

    public Anchor(Element first) {
        this.first = first;
    }

    public Element getFirst() {
        return first;
    }

    public void setFirst(Element first) {
        this.first = first;
    }

    public void insertAtTheFront(int x){
        Element element = new Element(first.getVal(), first.getNext());
        first = new Element(x, element);
    }

    public void insertAtTheEnd(int x){
        Element element = new Element(x, null);
        Element lastElement = getLastElement();

        lastElement.setNext(element);
    }

    public void removeFirst(){
        first = first.getNext();
    }

    public void removeLast(){
        Element lastButOne = getLastButOne();
        lastButOne.setNext(null);
    }

    public void showList(){
        Element iterator = first;
        while (iterator.getNext() != null){
            System.out.println(iterator.getVal());
            iterator = iterator.getNext();
        }
        System.out.println(iterator.getVal());
    }

    private Element getLastElement(){
        Element iterator = first;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        return iterator;
    }

    private Element getLastButOne(){
        Element iterator = first;
        while (iterator.getNext().getNext() != null){
            iterator = iterator.getNext();
        }
        return iterator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anchor anchor = (Anchor) o;
        return Objects.equals(first, anchor.first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first);
    }
}
