package kolekcje_1;

import java.util.ArrayList;
import java.util.Map;

public class Start {
    public static void main(String[] args) {

        ClientList clientList = new ClientList();
        clientList.show();

        for(int i = 0; i < 12; i++) {
            clientList.randomDiscountWithoutReplicates(i);
        }

        ArrayList<MyPair> repeatedNames = clientList.repeatedNames();
        Map<String, Integer> repeatedNamesMap = clientList.repeatedNamesMap();
    }
}
