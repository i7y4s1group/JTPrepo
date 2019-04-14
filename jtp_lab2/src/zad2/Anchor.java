package zad2;

public class Anchor {
	Element first;
	
	
	
	public void insertAtTheFront(int x) {
		
		Element newElement = new Element(x);
		newElement.setNext(first);
		first = newElement;
		
		
		
	}
	
	public void insertAtTheEnd(int x) {
		Element newElement = new Element(x);
		Element nextEle;
		nextEle = first.next;
		while(nextEle.next != null) {
			nextEle = nextEle.next;
			
		};
		nextEle.setNext(newElement);
	}
	
	public void removeFirst() {
		first = first.next;
	}
	
	public void removeLast() {
		
		Element nextEle;
		nextEle = first;
		while(nextEle.next.next != null){
			nextEle = nextEle.next;
			
		};
		
		nextEle.setNext(null);
		
		
	}
	
	
	public void out () {
		Element nextEle;
		nextEle = first;
		while(nextEle.next != null) {
			System.out.println(nextEle);
			nextEle = nextEle.next;
			
		};
		System.out.println(nextEle);
	}
	


	public Element getFirst() {
		return first;
	}

	public void setFirst(Element first) {
		this.first = first;
	}
	
}
