package zad1;

public class Client {
	String name;
	String surname;
	int orderNumber;
	
	public Client (String nName, String nSurname, int nOrder) {
		name = nName;
		surname = nSurname;
		orderNumber = nOrder;
	}
	
	public void display() {
		
		System.out.println(name + "    " +  surname);
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return orderNumber + "   " + name + "   " + surname;
	}
	 
	
}
