package pl.lab4.zadanie;

public class Product {
    private String productName;
    private int productPrice;
    private int productMargin;

    public void setProductMargin(int productMargin) {
        this.productMargin = productMargin;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
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
