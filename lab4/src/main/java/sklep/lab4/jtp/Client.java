package sklep.lab4.jtp;

import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Client extends Thread {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Client.class);
    private volatile boolean shutdown = false;
    private final int products = 3;
    private final int iterations;
    private final int sleepTime;
    private Shop shop;
    private Random random = new Random();

    public Client(Shop shop, int sleepTime, int iterations) {
        this.shop = shop;
        this.sleepTime = sleepTime;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        int i = 0;
        while(!shutdown) {
            if(i == iterations) {
                shop.shutdown();
                shutdown();
                break;
            }
            waitTime(sleepTime);
            ProductList chosenProducts = chooseProducts();
            if(chosenProducts.getSize() == products) {
                System.out.println("[Client] Chosen products: ");
                chosenProducts.show();
                String tmp = "";
                for(int k = 0; k < chosenProducts.getSize(); k++)
                    tmp = tmp + chosenProducts.getList().get(k) + " ";
                logger.info("[Client] Chosen products: ");
                logger.info(tmp);
                buyProducts(chosenProducts);
            }
            i++;
        }
    }

    private void waitTime(int sleepTime) {
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void buyProducts(ProductList chosenProducts) {
        for(int i = 0; i < chosenProducts.getSize(); i++) {
            Product product = chosenProducts.getList().get(i);
            shop.sell(product.getName());
        }
    }

    private ProductList chooseProducts() {
        ProductList chosenProducts = new ProductList();
        Warehouse warehouse = shop.getWarehouse();
        HashMap<String, ProductList> stock = warehouse.getStock();
        ArrayList<String> keysAsArray = new ArrayList<String>(stock.keySet());
        synchronized (shop.getWarehouse()) {
            while(chosenProducts.getSize() < products) {
                ArrayList<Product> chosenList = stock.get(keysAsArray.get(random.nextInt(stock.size()))).getList();
                if(chosenList.isEmpty()) {
                    if(warehouse.getSize() < products) {
                        System.out.println("[Client] There are not enough products for the client to buy");
                        logger.error("[Client] There are not enough products for the client to buy");
                        shop.shutdown();
                        break;
                    }
                    continue;
                }
                Product chosenProduct = chosenList.get(random.nextInt(chosenList.size()));
                if(chosenProducts.findProduct(chosenProduct) == null)
                    chosenProducts.getList().add(chosenProduct);
            }
        }
        return chosenProducts;
    }

    public void shutdown() {
        shutdown = true;
    }

}
