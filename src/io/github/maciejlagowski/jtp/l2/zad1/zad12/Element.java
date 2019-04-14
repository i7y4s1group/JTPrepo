package io.github.maciejlagowski.jtp.l2.zad1.zad12;

class Element {

    Element (int val) {
        this.val = val;
        this.next = null;
    }

    private int val;

    private Element next;

    void setNext(Element next) {
        this.next = next;
    }

    Element getNext() {
        return next;
    }

    int getVal() {
        return val;
    }

}
