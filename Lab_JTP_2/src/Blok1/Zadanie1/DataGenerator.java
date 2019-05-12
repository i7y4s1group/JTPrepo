package Blok1.Zadanie1;

import java.util.*;

public class DataGenerator {
    private final int NUMBER_OF_LETTERS = 26;
    private String[] names = {"Jan", "Krzysztof", "Przemyslaw",
            "Waldemar", "Elzbieta", "Anna", "Stanislaw", "Stefan", "Krystian", "Katarzyna"};
    private Random draw;

    public DataGenerator() {
        draw = new Random();
    }

    public List<Client> generateClients(int amount){

        List<Client> clients = new ArrayList<>();
        String name;
        String surname;
        int age;
        Client client;

        for (int i = 0; i < amount; i++) {
            name = names[i % names.length];

            if(i == 0) {
                surname = getLetter(i) + "backi";
            }
            else {
                surname = getLetter(i) + "abacki";
            }

            if(i > 26 && i % 26 == 0){
                surname = Character.toString(getLetter(i)) + Character.toString(getLetter(i)) + "backi";
            }
            else {
                surname = Character.toString(getLetter(i)) + Character.toString(getLetter(i)) + "abacki";
            }

            age = draw.nextInt(66) + 1;
            client = new Client(name, surname, age);

            clients.add(client);
        }

        return clients;
    }

    private char getLetter(int offset){
        return (char) ('A' + (offset % NUMBER_OF_LETTERS));
    }

    public int drawNumber(int range){
        return draw.nextInt(range);
    }
}
