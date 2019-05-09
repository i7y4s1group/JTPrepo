import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ClientList {
    private Random rand = new Random();
    private ArrayList<Client> list = new ArrayList<Client>();
    private ArrayList<Quantity> qua = new ArrayList<>();
    private final String[] Month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private final int N = 2;
    private Generator gen = new Generator();
    Map<String, Integer> map = new HashMap<String, Integer>();

    public void generate(){
        int randInt;

        for(int i = 0; i < 30; i++) {
            randInt = rand.nextInt(5);
            list.add(new Client(gen.generateName(), gen.generateSurname()));
        }
    }
    public void add(String newName, String newSurname) {
        Client newClient = new Client(newName, newSurname);
        list.add(newClient);
    }

    public void remove(int index) {
        list.remove(index);
    }
    public void show()
    {
        for(Client client:list)
        {
            System.out.println(client.toString());
        }
    }

    public boolean find(String imie, String nazwisko)
    {
        for(Client client:list)
        {
            if(client.getName().equals(imie) && client.getSurname().equals(nazwisko))
            {
                return true;
            }
        }
        return false;
    }

    public void randomDiscount(int mon) {
        int randInt;
        System.out.println("\nDiscounts: " + Month[mon]);
        for(int i = 0; i < N; i++) {
            randInt = rand.nextInt(list.size());
            System.out.println(randInt + ": " + list.get(randInt).toString());
        }
    }

    public void randomDiscountWR(int mon) {
        int randInt;
        System.out.println("\nDiscounts: " + Month[mon]);
        for(int i = 0; i < N; i++) {
            randInt = rand.nextInt(list.size());
            if(list.get(randInt).isCheck()== false)
            System.out.println(randInt + ": " + list.get(randInt).toString());
            list.get(randInt).setCheck(true); ;
        }

    }

    public void count() {
        int quantity;
        String[] names = gen.getNames();
        for(int i=0 ; i < 11; i++){
            quantity = 0;
            for(int j=0; j < list.size(); j++){
                if(names[i] == list.get(j).getName())
                    quantity++;
            }
            map.put(names[i], quantity);
            qua.add(new Quantity(names[i], quantity));

        }
        System.out.println("Counted number of repeated names(list):" );
        for(Quantity quan : qua) {
            System.out.println( quan.toString()) ;
        }

        System.out.println("Counted number of repeated names(map):");
        map.forEach((name, quanti) -> System.out.println(name + " " + quanti));


    }

}
