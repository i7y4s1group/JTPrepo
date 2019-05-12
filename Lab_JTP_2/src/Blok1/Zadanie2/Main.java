package Blok1.Zadanie2;

public class Main {
    public static void main(String[] args) {
        Element head = new Element(5, null);
        Anchor anchor = new Anchor(head);

        anchor.insertAtTheEnd(100);
        anchor.insertAtTheFront(20);
        anchor.insertAtTheFront(1);
        anchor.insertAtTheEnd(10234);
        anchor.showList();

        System.out.println();
        anchor.removeFirst();
        anchor.removeLast();
        anchor.showList();

        System.out.println();
        anchor.insertAtTheFront(2);
        anchor.insertAtTheEnd(-234);
        anchor.showList();
    }
}
