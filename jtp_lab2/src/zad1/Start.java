package zad1;

public class Start {

	public static void main(String[] args) {
		new ClientNames();
		ClientsColection kolo = new ClientsColection();
		/*kolo.addClient();
		kolo.addClient();*/
		for(int i = 0; i < 52; i++) {
			kolo.addClient();
		}
		kolo.displayClients();
		//kolo.generateWinners();
		//kolo.generateWinnersUnique();
		kolo.nameRepeatsTab();
		kolo.nameRepeatsMap();
		

	}

}
