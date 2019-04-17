package pl.lab2.zadanie1;

import java.util.ArrayList;
import java.util.Random;

public class ClientsCollection {
    private ArrayList<Client> clientsList;

    ClientsCollection() {
        clientsList = new ArrayList<Client>();
    }

    public void addClient(String name, String surname) {
        clientsList.add(new Client(name, surname));
    }

    public void deleteClient(String name, String surname) {
        clientsList.remove(getIndexOf(name, surname));
    }

    public boolean ifExists(String name, String surname) {
        return (getIndexOf(name, surname) != -1);
    }

    public String getClientName(int index) {
        return clientsList.get(index).getName();
    }

    public String getClientSurname(int index) {
        return clientsList.get(index).getSurname();
    }

    public int getIndexOfRandomClient() {
        Random random = new Random();
        return random.nextInt(clientsList.size());
    }

    public int getIndexOfRandomClient2() {
        for (int i = 0; i < clientsList.size(); i++) {
            int random = getIndexOfRandomClient();
            if (!clientsList.get(random).isSelected()) {
                return random;
            }
        }
        return -1;
    }

    private int getIndexOf(String name, String surname) {
        for (Client client : clientsList) {
            if (client.getName().compareTo(name) == 0 && client.getSurname().compareTo(surname) == 0) {
                return clientsList.indexOf(client);
            }
        }
        return -1;
    }
}
