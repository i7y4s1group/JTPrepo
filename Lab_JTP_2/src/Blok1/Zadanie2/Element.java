package Blok1.Zadanie2;

import java.util.Objects;

public class Element {
    private int val;
    private Element next;

    public Element(int val, Element next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return val == element.val &&
                Objects.equals(next, element.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
