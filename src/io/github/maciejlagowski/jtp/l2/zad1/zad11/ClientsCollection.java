package io.github.maciejlagowski.jtp.l2.zad1.zad11;

import java.util.ArrayList;
import java.util.Random;

class ClientsCollection {
    private ArrayList<Client> clientList = new ArrayList<>();

    ArrayList<Client> getClientList() {
        return clientList;
    }

    void addClient() {
        clientList.add(new Client(NamesDatabase.getRandomName()));
    }

    void addClient(int howMany) {
        for (int i = 0; i < howMany; i++) {
            clientList.add(new Client(NamesDatabase.getRandomName()));
        }
    }

    void deleteClient(int whichClient) {
        clientList.remove(whichClient);
    }

    void deleteClient(Client client) {
        clientList.remove(client);
    }

    Client searchClient(String forename, String surname) {
        for (Client client : clientList) {
            if (client.getForename().equals(forename) && client.getSurname().equals(surname)) {
                return client;
            }
        }
        return null;
    }

    int searchClient(Client client) {
        for (int i = 0; i < clientList.size(); i++) {
            if (client.equals(clientList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    Client randomClient() {
        Random random = new Random();
        return clientList.get(random.nextInt(clientList.size()));
    }

    void soutClients(Client[] clients) {
        for (Client client : clients) {
            System.out.println(client.getForename() + " " + client.getSurname());
        }
    }

    void soutClients() {
        for (Client client : clientList) {
            System.out.println(client.getForename() + " " + client.getSurname());
        }
    }
}
