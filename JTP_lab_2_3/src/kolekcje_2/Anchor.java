package kolekcje_2;

public class Anchor {
    private Element first;

    public Anchor() {
        first = null;
    }

    public void show() {
        Element tmp = first;
        while(tmp != null) {
            System.out.println(tmp.getVal());
            tmp = tmp.getNext();
        }
    }

    public void insertAtTheFront(int x) {
        if(first == null) {
            first = new Element(x);
        }
        else {
            Element newElement = new Element(x);
            newElement.setNext(first);
            first = newElement;
        }

    }

    public void insertAtTheEnd(int x) {
        if(first == null) {
            first = new Element(x);
        }
        else {
            Element tmp = first;
            while(tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            Element newElement = new Element(x);
            tmp.setNext(newElement);
        }
    }

    public void removeFirst() {
        if(first == null) {
            throw new NullPointerException("List is empty.");
        }
        else {
            Element tmp = first;
            first = first.getNext();
            tmp.setNext(null);

        }
    }

    public void removeLast() {
        if(first == null) {
            throw new NullPointerException("List is empty.");
        }
        else {
            Element tmp = first;
            while(tmp.getNext().getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(null);
        }
    }

    public int getElementVal(int i) {
        Element tmp = first;
        for(int j = 0; j < i; j++) {
            if(tmp.getNext() == null) throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
            tmp = tmp.getNext();
        }
        return tmp.getVal();
    }
}
