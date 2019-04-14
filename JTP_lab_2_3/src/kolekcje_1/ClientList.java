package kolekcje_1;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ClientList {
    private final String[] MONTH = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private final int N = 5;
    Integer[] randInt = new Integer[N];
    private ArrayList<Client> list = new ArrayList<Client>();

    public ClientList() {
        for(int i = 0; i < 52; i++) {
            list.add(new Client(Generator.nextName(), Generator.nextSurname()));
        }
    }

    public void show() {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i).getName() + " " + list.get(i).getSurname());
        }
    }

    public void add(String newName, String newSurname) {
        Client newClient = new Client(newName, newSurname);
        list.add(newClient);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public int findClient(String name, String surname) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getName() == name && list.get(i).getSurname() == surname)
                return i;
        }
        return -1;
    }

    public void randomDiscount(int mon) {
        Random rand = new Random();
        int randInt;
        System.out.println("\nDiscounts: " + MONTH[mon]);
        for(int i = 0; i < N; i++) {
            randInt = rand.nextInt(list.size());
            System.out.println(randInt + ": " + list.get(randInt).toString());
        }
    }

    public void randomDiscountWithoutReplicates(int mon) {
        Random rand = new Random();
        Integer tmp;

        System.out.println("\nDiscounts: " + MONTH[mon]);
        for(int i = 0; i < N; i++) {
            tmp = rand.nextInt(list.size());
            while(repeated(randInt, tmp, i+1)) {
                tmp = rand.nextInt(list.size());
            }
            randInt[i] = tmp;
            System.out.println(randInt[i] + ": " + list.get(randInt[i]).toString());
        }
    }

    public Map repeatedNamesMap() {

        Map<String, Integer> hm = new HashMap<String, Integer>();

        for(int i = 0; i < list.size(); i++) {
            Integer j = hm.get(list.get(i).getName());
            hm.put(list.get(i).getName(), (j == null) ? 1 : j + 1);
        }

        System.out.println("\nRepeated names with Map: ");
        for (Map.Entry<String, Integer> val : hm.entrySet()) {
            System.out.println(val.getKey() + ": " + val.getValue() + " times");
        }

        return hm;
    }

    public ArrayList repeatedNames() {
        ArrayList<MyPair> nameList = new ArrayList<MyPair>();
        String[] names = new String[10];
        int k = 0;

        for(int i = 0; i < list.size(); i++) {
            if(!repeated(names, list.get(i).getName(), 10)) {
                nameList.add(new MyPair(list.get(i).getName(), 0));
                names[k++] = list.get(i).getName();
            }
        }

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < list.size(); j++) {
                if(nameList.get(i).getName() == list.get(j).getName())
                    nameList.get(i).incrementNumber();
            }
        }

        System.out.println("\nRepeated names: ");
        for(int i = 0; i < k; i++) {
            System.out.println(
                    nameList.get(i).getName() + ": " + nameList.get(i).getNumber() + (nameList.get(i).getNumber() == 1 ? " time" : " times")
            );
        }
        return nameList;
    }

    private <T> boolean repeated(T[] tab, T check, int elements) {
        for(int j = 0; j < elements; j++) {
            if(check == tab[j]) {
                return true;
            }
        }
        return false;
    }
}
