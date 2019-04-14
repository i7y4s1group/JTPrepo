import java.util.ArrayList;
import java.util.*;

public class ClientsCollection {
    public List<Client> clients = new ArrayList<Client>();
    public List<String> names = new ArrayList<String>();
    public int secondNamePrefixIndex;

    public ClientsCollection()
    {
        secondNamePrefixIndex = 0;
    }

    public void addName(String name)
    {
        names.add(name);
    }

    public void addClient(String name, String secondName)
    {
        System.out.println("Dodano klienta: " + name + " " + secondName);
        clients.add(new Client(name, secondName));
    }

    public void removeClient(String name, String secondName)
    {
        for (Client k : clients)
        {
            if(k.name.compareTo(name) == 0 && k.secondName.compareTo(secondName) == 0)
            {
                System.out.println("Usunięto klienta: " + k.name + " " + k.secondName);
                clients.remove(k);

                break;
            }
        }
    }

    public Client findClient(String name, String secondName)
    {
        for (Client k : clients)
        {
            if(k.name.compareTo(name) == 0 && k.secondName.compareTo(secondName) == 0)
            {
                System.out.println("Znaleziono klienta: " + k.name + " " + k.secondName);

                return k;
            }
        }

        return null;
    }

    public void randomClient()
    {
        int random = (int)(Math.random() * (double)clients.size());

        for (Client k : clients)
        {
            if(random == clients.indexOf(k))
            {
                System.out.println("Wylosowano klienta: " + k.name + " " + k.secondName);
                return;
            }
        }

        System.out.println("Nikogo nie wylosowano!");
    }

    public void randomClient2() {
        int random = (int)(Math.random() * (double)clients.size());

        for (Client k : clients)
        {
            if(random == clients.indexOf(k))
            {
                if(k.selected)
                {
                    randomClient2();
                }
                else
                {
                    k.selected = true;
                    System.out.println("Wylosowano klienta: " + k.name + " " + k.secondName);
                }
                return;
            }
        }

        System.out.println("Nikogo nie wylosowano!");
    }

    public void genClient()
    {
        int nameId = (int)(Math.random() * (double)names.size());
        String name = names.get(nameId);
        char prefix1 = 0;
        char prefix2 = 0;
        char prefixStart = 'A';

        if(secondNamePrefixIndex < 26)
        {
            prefix1 = (char)(prefixStart + secondNamePrefixIndex);
        }
        else
        {
            prefix1 = (char)(prefixStart + (secondNamePrefixIndex / 26));
            prefix2 = (char)(prefixStart + (secondNamePrefixIndex % 26));
        }

        secondNamePrefixIndex++;
    }
}
