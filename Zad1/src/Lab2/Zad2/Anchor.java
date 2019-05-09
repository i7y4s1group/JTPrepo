package Lab2.Zad2;

public class Anchor {
    private Element first;
    private Element last;
    private int size;

    public Anchor(){
        first = null;
        last = null;
        size = 0;
    }

    public void insertAtTheFront(int x){
        if(first == null){
            first = new Element();
            last = first;
            first.setVal(x);
            first.setNext(null);

        }
        else{
            Element element = new Element();
            element.setVal(x);
            element.setNext(first);
            first = element;
        }
        size++;
    }

    public void insertAtTheEnd(int x) {
        if (first == null) {
            first = new Element();
            last = first;
            first.setVal(x);
            first.setNext(null);
        } else {
            Element element = new Element();
            element.setVal(x);
            element.setNext(null);
            last.setNext(element);
            last = element;
        }
        size++;
    }

    public void removeFirst(){
        if(first != null) {
            first = first.getNext();
            size--;
        }
    }

    public void removeLast(){
        if(last != null) {
            Element element = first;

            for (int i = 0; i < size - 1; i++) {
                element = element.getNext();
            }
            element.setNext(null);
            last = element;
            size--;
        }
    }

    public void show(){
        Element element = first;
        System.out.print("{");
        for (int i = 0; i < size; i++) {
            System.out.print(element.getVal() + ". ");
            element = element.getNext();
        }
        System.out.println("}");
    }
}
