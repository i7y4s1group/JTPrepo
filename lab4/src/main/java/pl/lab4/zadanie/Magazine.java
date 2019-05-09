package pl.lab4.zadanie;

import java.util.ArrayList;

public class Magazine extends Shop {
    private ArrayList<Product> productsList = new ArrayList<Product>();
    private final int lowerLimit = 1;

    Magazine() {
        super(new RandomNumberGenerator(1,50).getRandomNumber());
        for (char name = 65; name < 85; name++) {
            int productRandomQuantity = new RandomNumberGenerator(lowerLimit, 20).getRandomNumber();
            int productRandomPrice = new RandomNumberGenerator(5, 30).getRandomNumber();
            int purchasePrice = new RandomNumberGenerator(1, productRandomPrice).getRandomNumber();
            int productRandomMargin = productRandomPrice - purchasePrice;
            for (int j = 0; j < productRandomQuantity; j++) {
                Product product = new Product.Builder()
                        .productName(String.valueOf(name))
                        .productPrice(productRandomPrice)
                        .productMargin(productRandomMargin)
                        .build();
                productsList.add(product);
            }
        }
    }

    public void buyProducts(String productName, int quantity) {
        Product product = getProductByName(productName);
        if (product != null) {
            while (productQuantity(product) > 1) {
                productsList.remove(product);
                increaseBudget(product.getProductPrice());
            }
            refillMagazine(product);
        }
    }

    private void refillMagazine(Product product) {
        if (isProductReachTheLimit(product)) {
            if (getBudget() >= product.getProductPrice()) {
                int productsAmountPossibleToBuy = getBudget() / product.getProductPrice();
                productsAmountPossibleToBuy /= 2;
                addProducts(product, productsAmountPossibleToBuy);
            }
        }
    }

    public void addProduct(Product product) {
        productsList.add(product);
    }

    public void addProducts(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addProduct(product);
        }
    }

    private Product getProductByName(String productName) {
        for (Product product : productsList) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

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
        return productQuantity(product) <= lowerLimit;
    }
}
