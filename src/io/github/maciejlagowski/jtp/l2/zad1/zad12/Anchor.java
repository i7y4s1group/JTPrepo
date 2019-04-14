package io.github.maciejlagowski.jtp.l2.zad1.zad12;

class Anchor {

    private int size;

    private Element first;

    private Element last;

    void insertAtTheFront(int x) {
        if(first == null) {
            first = new Element(x);
            last = first;
        }
        else {
            Element element = new Element(x);
            element.setNext(first);
            first = element;
        }
        size++;
    }

    void insertAtTheEnd(int x) {
        if(first == null) {
            first = new Element(x);
            last = first;
        }
        else {
            Element element = new Element(x);
            last.setNext(element);
            last = element;
        }
        size++;
    }

    void removeFirst() {
        if(first != null) {
            Element element = first.getNext();
            first = element;
            size--;
        }
    }

    void removeLast() {
        if(first != null) {
            if(first == last) {
                first = null;
                last = null;
            }
            else {
                Element element = first;
                for (int i = 0; i < (size - 2); i++) {
                    element = element.getNext();
                }
                element.setNext(null);
                size--;
            }
        }
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        String string = "";
        if(first != null) {
            Element element = first;
            Integer integer = first.getVal();
            string = integer.toString();
            for (int i = 0; i < (size - 1); i++) {
                element = element.getNext();
                integer = element.getVal();
                string += ", " + integer.toString();
            }
        }
        return "Anchor{" + string + "}";
    }

    public Element getLast() {
        return last;
    }

    public Element getFirst() {
        return first;
    }
}
