package io.github.maciejlagowski.jtp.l2.zad1.zad12;

public class Main {
    public static void main(String[] args) {

        Anchor anchor = new Anchor();
        anchor.insertAtTheEnd(12);
        anchor.insertAtTheFront(13);
        anchor.insertAtTheFront(15);
        anchor.removeLast();
        anchor.removeLast();
        anchor.removeFirst();
        anchor.removeLast();
        System.out.println(anchor);
        System.out.println("sizeof anchor = " + anchor.size());
        anchor.insertAtTheEnd(10);
        anchor.insertAtTheFront(15);

        System.out.println(anchor.getFirst().getVal());
        System.out.println(anchor);
        System.out.println("sizeof anchor = " + anchor.size());

    }
}
