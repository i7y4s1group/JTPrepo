package pl.lab4.zadanie;

import java.util.ArrayList;

public class Magazine {
    private ArrayList<Product> productsList = new ArrayList<Product>();
    private final int limit = 1;

    private int productQuantity(Product product) {
        int quantity = 0;
        for (Product prod : productsList) {
            if (prod.equals(product)) {
                quantity++;
            }
        }
        return quantity;
    }

    private boolean isProductReachTheLimit(Product product) {
        return productQuantity(product) <= limit;
    }
}
