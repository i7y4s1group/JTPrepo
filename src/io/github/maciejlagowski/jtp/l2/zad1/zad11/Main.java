package io.github.maciejlagowski.jtp.l2.zad1.zad11;

public class Main {
    public static void main(String[] args) {
        ClientsCollection clients = new ClientsCollection();
        clients.addClient(300);

        ForenamesCounter.countForenamesOnArray(clients.getClientList());
        ForenamesCounter.countForenamesOnMap(clients.getClientList());

        System.out.println();
        clients.soutClients();

        RandomWinnerPicker randomWinnerPicker = new RandomWinnerPicker(clients);
        try {
            randomWinnerPicker.run(2, 2);
        } catch (Exception ex) {
            System.err.println("Err: You can't random more clients than 10% of database.");
        }
    }
}
