package zad1;

import java.util.List;
/*import java.util.ArrayList;*/


public class ClientTab {
	static String [] names;
	static int [] repeatCounter = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static int index = 0;
	
	

	public void loop(List <Client> dataBase) {
		String name;
		String [] namesDataBase = ClientNames.getNames();
		index = ClientNames.getNames().length;
		
		for(String n: namesDataBase) {
			names = namesDataBase;
		}
		
		
		for (int i = 0; i < dataBase.size(); i++) {
			name = dataBase.get(i).getName();
			for (int j = 0; j < index; j++) {
				if (names[j] == name) {
					repeatCounter[j]++;
				}
			}			
		}
		
	}
	
	public void out(){		
		for (int i = 0; i < index ; i++) {
			System.out.println(names[i] + "   " + repeatCounter[i]);		
		}
		
	}
	
}
