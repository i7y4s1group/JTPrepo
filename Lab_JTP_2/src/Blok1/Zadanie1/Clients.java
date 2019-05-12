package Blok1.Zadanie1;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Clients {
    private final int NUMBERS_OF_CLIENTS = 30;
    private final int N = (int)(NUMBERS_OF_CLIENTS * 0.1);
    private final int NUMBER_OF_MONTHS = 12;
    private List<Client> clients;
    private DataGenerator dataGenerator;

    public Clients() {
        dataGenerator = new DataGenerator();
        clients = dataGenerator.generateClients(NUMBERS_OF_CLIENTS);
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void showClients(){
        AtomicInteger counter = new AtomicInteger();
        clients.forEach(client -> {
            System.out.println("NUMER KLIENTA: " + counter.getAndIncrement());
            System.out.println(client);
        });
    }

    public void removeClient(){
        Scanner sc = new Scanner(System.in);
        int choice;

        showClients();
        System.out.print("KLIENT DO USUNIECIA: ");
        choice = Integer.parseInt(sc.nextLine());

        if(choice < clients.size())
            clients.remove(choice);
    }

    public Client searchForClient(String name, String surname){
        for(Client client : clients){
            if(client.getName().equals(name) && client.getSurname().equals(surname))
                return client;
        }
        return null;
    }

    public List<NameCounter> numberOfRepetitionsOfNamesV2(){
        List<NameCounter> result = new ArrayList<>();
        NameCounter name;
        int index = 0;
        boolean found = false;

        for(Client client : clients){
            for (NameCounter counter : result) {
                if(counter.getName().equals(client.getName())){
                    found = true;
                    counter.count();
                    break;
                }
            }

            if (!found){
                name = new NameCounter(client.getName(), 1);
                result.add(name);
            }
            found = false;
        }

        return result;
    }

    public Map<String, Long> numberOfRepetitionsOfNames(){
       return clients
                .stream()
                .map(client -> client.getName())
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
    }

    public Map<Client, Long> numberOfClientWinnings(Map<Integer, List<Client>> results){
        return results
                .entrySet()
                .stream()
                .flatMap(result -> result.getValue().stream())
                .collect(Collectors.groupingBy(result -> result, Collectors.counting()));
    }

    public Map<Integer, List<Client>> drawingClientsEveryMonth(boolean repetitions){
        Map<Integer, List<Client>> winners = new HashMap<>();

        for (int i = 0; i < NUMBER_OF_MONTHS; i++) {
            if(repetitions) {
                winners.put(i + 1, drawClientsWithRepetitions());
            }
            else {
                winners.put(i + 1, drawClientsWithoutRepetitions());
            }
        }

        return winners;
    }

    public List<Client> drawClientsWithRepetitions(){
        List<Client> result = new ArrayList<>();
        int drawNumber;
        Client drawClient;
        for (int i = 0; i < N; i++) {
            drawNumber = dataGenerator.drawNumber(NUMBERS_OF_CLIENTS);
            drawClient = clients.get(drawNumber);
            result.add(drawClient);
        }
        return result;
    }

    public List<Client> drawClientsWithoutRepetitions(){
        List<Client> result = new ArrayList<>();
        int drawNumber;
        Client drawClient;
        int i = 0;

        while(i < NUMBERS_OF_CLIENTS) {
            drawNumber = dataGenerator.drawNumber(N);
            drawClient = clients.get(drawNumber);
            if(!result.contains(drawClient)){
                result.add(drawClient);
                i++;
            }
        }
        return result;
    }

    public Clients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
