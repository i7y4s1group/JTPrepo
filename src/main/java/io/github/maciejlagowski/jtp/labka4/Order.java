package io.github.maciejlagowski.jtp.labka4;

import org.apache.log4j.Logger;
import java.util.Map;

class Order extends Thread {
    //Variables
    private final Integer limit = Main.config.getMinQuantity();
    private final Integer howManyToOrder = limit * 5;
    private Warehouse warehouse;
    private DeliverProducts deliverProducts;
    private Logger logger = LoggerClass.getLogger();

    //Methods
    Order(Warehouse warehouse) {
        this.warehouse = warehouse;
        deliverProducts = new DeliverProducts(howManyToOrder, warehouse);
    }

    @Override
    public void run() {
        while (!warehouse.isBlocked()) {
            checkWarehouse();
        }
    }

    private void checkWarehouse() {
        Map<Product, Integer> productMap = warehouse.getProductMap();
        for (Product product : productMap.keySet()) {
            if (productMap.get(product) < limit) {
                deliverProducts.setProduct(product);
                logger.warn(product + " is below the limit, need to order.");
                deliverProducts.run();
            }
        }
    }
}
