package Lab2.Zad2;

public class Main {
    public static void main(String[] args) {
        Anchor anchor = new Anchor();
        anchor.insertAtTheFront(5);
        anchor.insertAtTheFront(1);
        anchor.insertAtTheEnd(6);
        anchor.insertAtTheEnd(7);

        anchor.show();
        anchor.removeFirst();
        anchor.removeFirst();
        anchor.removeFirst();
        anchor.removeFirst();
        anchor.removeFirst();
        anchor.show();
        anchor.insertAtTheFront(1);

        anchor.show();
    }
}
