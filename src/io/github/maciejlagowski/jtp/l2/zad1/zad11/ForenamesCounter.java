package io.github.maciejlagowski.jtp.l2.zad1.zad11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ForenamesCounter {

    static void countForenamesOnArray(ArrayList<Client> clientList) {
        ArrayList[] array = new ArrayList[2];
        array[0] = new ArrayList<String>();
        array[1] = new ArrayList<Integer>();
        for (Client client : clientList) {
            if (!ifForenameWasUsed(client.getForename(), array)) {
                array[0].add(client.getForename());
                array[1].add(1);
            }
        }
        System.out.println("Forename: " + array[0]);
        System.out.println("Count: " + array[1]);
    }

    private static boolean ifForenameWasUsed(String forename, ArrayList[] array) {
        for (int i = 0; i < array[0].size(); i++) {
            if (forename.equals(array[0].get(i))) {
                int number = (int) array[1].get(i);
                number++;
                array[1].set(i, number);
                return true;
            }
        }
        return false;
    }

    static void countForenamesOnMap(ArrayList<Client> clientList) {
        Map<String, Integer> map = new HashMap<>();
        Integer freq;
        for (Client client : clientList) {
            freq = map.get(client.getForename());
            map.put(client.getForename(), ((freq == null) ? 1 : freq + 1));
        }
        System.out.println(map);
    }
}
