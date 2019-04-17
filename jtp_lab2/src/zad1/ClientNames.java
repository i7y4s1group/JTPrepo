package zad1;



public class ClientNames {
	private final static String [] NAMES = {"Sebastian", "Kacper", "Filip", "Kamil", "Wiktor", "Robert",
						"Przemys³aw", "Krystian", "Patryk", "Maciej", "Mateusz",
						"Piotr", "Zbigniew", "Hans"};
	private final static String [] SURNAMES = {"Abacki", "Babacki", "Cabacki", "Dabacki", "Eabacki", 
			"Fabacki", "Gabacki", "Habacki", "Iabacki", "Jabacki", "Kabacki", 
			"Labacki", "Mabacki", "Nabacki", "Oabacki", "Pabacki", "Qabacki", 
			"Rabacki", "Sabacki", "Tabacki", "Uabacki", "Vabacki", "Wabacki", 
			"Xabacki", "Yabacki", "Zabacki" };			
	private static int namesCount = 0;
	private static int surnamesCount = 0;
	private static char increment = 'A';
	
	
	public static String randomName () {
		String name = NAMES[namesCount % ClientNames.NAMES.length];
		namesCount ++;
		
		return name;
	}
	public static String randomSurname() {
		String surname = SURNAMES[surnamesCount % ClientNames.SURNAMES.length];
		surnamesCount ++;
		if (surnamesCount > 26) {
			surname = increment + surname;
			increment ++;
			if (increment > 'Z') {
				increment = 'A';
			}
		}		
		return surname;
	}
	public static String[] getNames() {
		
		return NAMES;
	}
	
}
