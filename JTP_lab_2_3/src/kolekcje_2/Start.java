package kolekcje_2;

public class Start {
    public static void main(String[] args) {
        Anchor list = new Anchor();

        for (int i = 0; i < 5; i++) {
            list.insertAtTheFront(i);
        }
        for (int i = 5; i < 10; i++) {
            list.insertAtTheEnd(i);
        }
        list.show();

        System.out.println("\n");
        for(int i = 0; i < 3; i++) {
            list.removeFirst();
        }
        list.show();

        System.out.println("\n");
        for(int i = 0; i < 3; i++) {
            list.removeLast();
        }
        list.show();

    }
}
