public class Main {

    public static void main(String[] args) {
        Anchor anchor = new Anchor();


        anchor.insertAtTheEnd(15);
        anchor.insertAtTheEnd(16);
        anchor.insertAtTheEnd(17);
        anchor.insertAtTheEnd(18);
        anchor.show();

        anchor.removeFirst();
        anchor.show();

        anchor.insertAtTheFront(300);
        anchor.show();

        anchor.removeLast();
        anchor.show();

    }
}
