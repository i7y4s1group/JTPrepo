package zad2;

class Element {
	int Value;
	Element next;
	
	public Element (int x) {
		Value = x;
		setNext(null);
		
	}
	
	
	@Override
	public String toString() {
		return "Element [Value=" + Value + "]";
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	public Element getNext() {
		return next;
	}
	public void setNext(Element next) {
		this.next = next;
	}

	
}
