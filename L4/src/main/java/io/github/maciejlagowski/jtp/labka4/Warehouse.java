package io.github.maciejlagowski.jtp.labka4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class Warehouse {
    // Variables
    private volatile Map<Product, Integer> productMap;
    private volatile boolean blocked = false;
    private volatile Double money = Main.config.getMoney();

    // Methods
    Warehouse() {
        productMap = new HashMap<>();
    }

    Double getMoney() {
        return money;
    }

    void setMoney(Double money) {
        this.money = money;
    }

    int getQuantityOfProduct(Product product) {
        return productMap.get(product);
    }

    void setQuantityOfProduct(Product product, Integer quantity) {
        productMap.replace(product, quantity);
    }

    void addProduct(Product product, Integer quantity) {
        productMap.put(product, quantity);
    }

    void removeProduct(Product product) {
        productMap.remove(product);
    }

    String showWarehouse() {
        return "Warehouse: " + productMap;
    }

    Product getProduct(String name) {
        for (Product product : productMap.keySet()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    Product getRandomProduct() {
        Random rand = new Random();
        int id = rand.nextInt(productMap.size());
        int i = 0;
        for (Product product : productMap.keySet()) {
            if (i == id) {
                return product;
            }
            i++;
        }
        return null;
    }

    Map getProductMap() {
        return productMap;
    }

    void block() {
        blocked = true;
    }

    boolean isBlocked() {
        return blocked;
    }

    int countProducts() {
        return productMap.size();
    }

    void insertProductsInWarehouse(List<Product> productList) {
        Random rand = new Random();
        for (Product product : productList) {
            addProduct(product, rand.nextInt(150) + 50);
        }
    }
}
