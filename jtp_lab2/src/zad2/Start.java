package zad2;

public class Start {

	public static void main(String[] args) {
		Anchor list = new Anchor();
		list.insertAtTheFront(5);
		list.insertAtTheFront(4);
		list.insertAtTheFront(3);
		list.insertAtTheFront(2);
		list.insertAtTheFront(1);
		list.insertAtTheEnd(6);
		list.insertAtTheEnd(7);
		list.insertAtTheEnd(8);
		list.out();
		System.out.println("Po");
		list.removeFirst();
		list.removeLast();
		list.removeLast();
		list.removeLast();
		list.out();

	}

}
