package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;



public class ClientsColection {
	
	int position = 0;
	List <Client> dataBase = new ArrayList <Client>();
	

	public void addClient() {
		dataBase.add(new Client (ClientNames.randomName(), ClientNames.randomSurname(), position++));
		
	}
	
	public void displayClients() {
		for (Client c : dataBase) {
			System.out.println(c);
		}
		
	//	dataBase.forEach(System.out::println);
		
	}
	
	
	public void removeClient(String name) {
		dataBase.removeIf(c -> c.getSurname().equals(name));	
		
	}
	public Optional<Client> searchClient(String name) {
		return dataBase.stream().filter(c -> c.getSurname().equals(name)).findFirst();
		
	}
	
	public Optional<Client> searchClient(int number) {
		return dataBase.stream().filter(c -> c.getOrderNumber() == number).findFirst();
		
	}
	
	public void generateWinners() {
		Random rand = new Random();
		int max = rand.nextInt(position/10);
		for (int i=0; i < max; i++) {
			System.out.println(searchClient(0+ rand.nextInt(position)));	
		}
	}
	
	
	public void generateWinnersUnique() {
		Random rand = new Random();
		int max = rand.nextInt(position/10);	//losowanie N-elementów
		
		int [] tab = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}; 		//tablica s³u¿¹ca do sprawdzania powtórzeñ
		// -1, dlatego, ¿e pierwszy cz³onek listy ma orderNumber = 0
		
		int index = 0;					//index potrzebny do chodzenia po tablicy
		int random;						//zmienna przechowuj¹ca bierz¹cy wylosowany numer
		boolean repeat = false;			//zmienna okreœlaj¹ca czy by³o powtórzenie
		
		for (int i=0; i < max; i++) {
			random = rand.nextInt(position);		//losowanie liczby
			
			for (int j=0; j < index; j++) {
				if (tab[j] == random) {				//jeœli jest ju¿ w tablicy, to losuj jeszcze raz
					i--;
					repeat = true;
					break;
					
				}
			}
			if (!repeat) {							//jeœli nie ma w tablicy, to dodaj do tablicy, i wydrukuj
				tab[index] = random;				
				System.out.println(searchClient(random));	
				
			}
			index ++;								
			repeat = false;
		}
		
		
	}
		
	public void nameRepeatsTab() {
		ClientTab tab = new ClientTab();
		tab.loop(dataBase);
		tab.out();
		
	}
	
	
	public void nameRepeatsMap() {
		Map <String, Integer> namesMap = new HashMap<>();
		String [] namesDataBase = ClientNames.getNames();
		int count = 0;
		for (int j = 0; j < namesDataBase.length; j++) {
			for (int i = 0; i < dataBase.size(); i++ ) {
				if (namesDataBase[j] == dataBase.get(i).name) {
					count++;
				}				
			}
			namesMap.put(namesDataBase[j], count);
			count = 0;
		}
		
		
		for (Map.Entry<String, Integer> namesMapEntry : namesMap.entrySet()) {
		    final String name = namesMapEntry.getKey();
		    final Integer count2 = namesMapEntry.getValue();
		    System.out.println("Name: " + name + ", Count: " + count2);
		}
	}
	
}
