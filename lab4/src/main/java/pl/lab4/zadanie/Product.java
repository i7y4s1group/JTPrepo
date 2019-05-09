package pl.lab4.zadanie;

import javafx.util.Builder;

public class Product {
    private String productName;
    private int productPrice;
    private int productMargin;

    public static class Builder {
        private String productName;
        private int productPrice;
        private int productMargin;

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder productPrice(int productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public Builder productMargin(int productMargin) {
            this.productMargin = productMargin;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    private Product(Builder builder) {
        this.productName = builder.productName;
        this.productPrice = builder.productPrice;
        this.productMargin = builder.productMargin;
    }

    public int getProductMargin() {
        return productMargin;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }
}
