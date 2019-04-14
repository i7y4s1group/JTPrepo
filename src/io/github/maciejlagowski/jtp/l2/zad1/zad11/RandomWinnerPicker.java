package io.github.maciejlagowski.jtp.l2.zad1.zad11;

import java.util.ArrayList;

class RandomWinnerPicker {

    private ClientsCollection clientsCollection;
    private ArrayList<Client> clientList;

    RandomWinnerPicker(ClientsCollection clientsCollection) {
        this.clientsCollection = clientsCollection;
        this.clientList = clientsCollection.getClientList();

    }

    Client[] getRandomClients(int n) throws Exception {
        if (n > (0.1 * clientList.size())) {
            throw new Exception();
        }
        Client[] clientsTab = new Client[n];
        for (int i = 0; i < n; i++) {
            clientsTab[i] = clientsCollection.randomClient();
        }
        return clientsTab;
    }

    Client[] getRandomClientsButBetter(int n) throws Exception {
        if (n > (0.1 * clientList.size())) {
            throw new Exception();
        }
        Boolean[] flagTab = new Boolean[clientList.size()];
        for (int i = 0; i < clientList.size(); i++) {
            flagTab[i] = false;
        }
        Client[] clientsTab = new Client[n];
        Client tempClient;
        for (int i = 0; i < n; i++) {
            do {
                tempClient = clientsCollection.randomClient();
            } while (flagTab[clientsCollection.searchClient(tempClient)]);
            clientsTab[i] = tempClient;
            flagTab[clientsCollection.searchClient(tempClient)] = true;
        }
        return clientsTab;
    }

    private void randomMonth(int howManyToRandom) throws Exception {
        System.out.println("--------------------------");
        System.out.println("Random picker:");
        System.out.println("--------------------------");
        clientsCollection.soutClients(getRandomClients(howManyToRandom));
        System.out.println("--------------------------");
        System.out.println("Better Random picker:");
        System.out.println("--------------------------");
        clientsCollection.soutClients(getRandomClientsButBetter(howManyToRandom));
    }

    void run(int howManyToRandom, int howManyMonths) throws Exception {
        for (int i = 1; i <= howManyMonths; i++) {
            System.out.println();
            System.out.println("#############");
            System.out.println("Month " + i);
            randomMonth(howManyToRandom);
        }
    }
}
