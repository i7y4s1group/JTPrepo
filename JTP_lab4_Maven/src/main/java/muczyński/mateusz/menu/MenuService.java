package muczyński.mateusz.menu;

import javafx.scene.control.ProgressBar;
import muczyński.mateusz.model.Product;
import muczyński.mateusz.model.enums.Category;
import muczyński.mateusz.service.*;
import muczyński.mateusz.windows.StageContainer;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class MenuService {
    private final int MINIMUM_BUDGET = 60;
    private final int NUMBER_OF_CLIENTS;
    private final int WAIT;
    private Map<Category, List<Product>> initialProducts;
    private Storehouse storehouse;
    private CompanyFinances companyFinances;
    private ClientService[] clients;
    private OrderService orderService;
    private Semaphore iAmBuying;
    private Semaphore ordering;

    public MenuService(int numberOfClients, int time) {
        NUMBER_OF_CLIENTS = numberOfClients;
        WAIT = time;
        initElements();
    }

    private void initElements(){
        storehouse = new Storehouse("D:\\WAT_PROGRAMY\\JTP_lab4_Maven\\src\\main\\java\\muczyński\\mateusz\\products.txt");
        companyFinances = new CompanyFinances();
        clients = new ClientService[NUMBER_OF_CLIENTS];
        iAmBuying = new Semaphore(1);
        ordering = new Semaphore(1);

        initialProducts = copyMap();

        for (int i = 0; i < NUMBER_OF_CLIENTS; i++) {
            clients[i] = new ClientService(WAIT, storehouse, iAmBuying, i + 1, companyFinances);
        }
    }

    public void runApp(){

        deleteOldLogFiles();

        for (int i = 0; i < NUMBER_OF_CLIENTS; i++) {
            Thread thread = new Thread(clients[i]);
            thread.start();
        }

        while (companyFinances.getBudget().compareTo(BigDecimal.valueOf(MINIMUM_BUDGET)) > 0){

            System.out.println("SYMULACJA W TOKU -> BUDZET : " + companyFinances.getBudget());

            if(!areMissingProducts()){
                wait(6000);
            }

            semaphordeDown(ordering);

            orderService = new OrderService(initialProducts, storehouse, companyFinances, ordering);
            Thread thread = new Thread(orderService);
            thread.start();
        }
    }

    private boolean areMissingProducts(){
        boolean[] weMustOrder = new boolean[1];

        storehouse.getProducts().forEach(((category, listOfProducts) -> {
            if(listOfProducts.size() <= 2){
                weMustOrder[0] = true;
            }
        }));

        return weMustOrder[0];
    }

    private void deleteOldLogFiles(){
        File info = new File("info.log");
        File warn = new File("warn.log");

        if(info.exists()){
            info.delete();
        }

        if(warn.exists()){
            warn.delete();
        }
    }

    private void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Map<Category, List<Product>> copyMap(){
        Map<Category, List<Product>> copy = new HashMap<>();

        for (Map.Entry<Category, List<Product>> entry : storehouse.getProducts().entrySet()) {
            copy.put(entry.getKey(),
                    new ArrayList<Product>(entry.getValue()));
        }
        return copy;
    }

    private void semaphordeDown(Semaphore semaphore){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
