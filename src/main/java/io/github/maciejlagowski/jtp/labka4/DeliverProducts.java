package io.github.maciejlagowski.jtp.labka4;

import org.apache.log4j.Logger;

class DeliverProducts extends Thread {
    //Variables
    private final Integer howManyToOrder;
    private Warehouse warehouse;
    private Product product;
    private Logger logger = LoggerClass.getLogger();

    //Methods
    DeliverProducts(Integer howManyToOrder, Warehouse warehouse) {
        this.howManyToOrder = howManyToOrder;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        if ((product.getValue() * howManyToOrder) < warehouse.getMoney()) {
            logger.info("<<< ordering " + product + " money" + warehouse.getMoney() + " need " + product.getValue() * howManyToOrder);
            warehouse.setMoney(warehouse.getMoney() - (product.getValue() * howManyToOrder));
            Integer quantityInWarehouse = warehouse.getQuantityOfProduct(product) + howManyToOrder;
            warehouse.setQuantityOfProduct(product, quantityInWarehouse);
            logger.info(">>> ordering completed ");
            logger.info(warehouse.showWarehouse());
        } else {
            logger.error("ordering" + product + " fail, closing warehouse.");
            warehouse.block();
        }
    }

    void setProduct(Product product) {
        this.product = product;
    }
}
