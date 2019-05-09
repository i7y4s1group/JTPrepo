import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ClientList clientList = new ClientList();
        clientList.generate();
        clientList.show();
        for(int i = 0; i < 12; i++) {
            clientList.randomDiscountWR(i);
        }
        for(int i = 0; i < 12; i++) {
            clientList.randomDiscount(i);
        }
        clientList.count();
    }
}
