package io.github.maciejlagowski.jtp.labka4;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Client extends Thread {
    //Variables
    private Map<Product, Integer> shoppingMap = new HashMap<>();
    private Random rand = new Random();
    private Warehouse warehouse;
    private int clientId;
    private Logger logger = LoggerClass.getLogger();
    private CsvClass csv;

    //Methods
    Client(Warehouse warehouse, int clientId) throws IOException {
        this.warehouse = warehouse;
        this.clientId = clientId;
        this.csv = new CsvClass(clientId);
    }

    @Override
    public void run() {
        while (!warehouse.isBlocked()) {
            sleepMinutes(rand.nextInt(Main.config.getMaxClientDelay()) + 1);
            int productsCounter = warehouse.countProducts();
            if (productsCounter <= 0) {
                continue;
            }
            int howManyProducts = rand.nextInt(productsCounter) + 2;
            for (int i = 0; i < howManyProducts; i++) {
                buyProduct();
            }
            csv.printCsv("map" + clientId + " = " + shoppingMap);
            warehouse.showWarehouse();
        }
    }

    private synchronized void buyProduct() {
        Product randomProduct = warehouse.getRandomProduct();
        Integer quantityInWarehouse = warehouse.getQuantityOfProduct(randomProduct);
        if (quantityInWarehouse > 0) {
            Integer howMany = rand.nextInt(quantityInWarehouse) + 1;
            Integer quantityInTheBasket = shoppingMap.get(randomProduct);
            shoppingMap.put(randomProduct, (quantityInTheBasket == null) ? howMany : howMany + quantityInTheBasket);
            warehouse.setQuantityOfProduct(randomProduct, (quantityInWarehouse - howMany));
            logger.info("Client" + clientId + " bought  " + randomProduct + ": " + howMany);
        }
    }

    private void sleepMinutes(int minutes) {
        try {
            sleep(minutes * 60/*000*/); //uncomment zeros to get real minutes
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
