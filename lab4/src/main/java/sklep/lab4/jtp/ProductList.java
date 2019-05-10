package sklep.lab4.jtp;

import java.util.ArrayList;

public class ProductList {
    private ArrayList<Product> productList = new ArrayList<Product>();

    public synchronized int getSize() {
        return productList.size();
    }

    public ArrayList<Product> getList() {
        return productList;
    }

    public synchronized Product findProduct(String productName) {
        for(int i = 0; i < getSize(); i++) {
            if(productName.equals(productList.get(i).getName()))
                return productList.get(i);
        }
        return null;
    }
    public synchronized Product findProduct(Product product) {
        for(int i = 0; i < getSize(); i++) {
            if(product.equals(productList.get(i)))
                return product;
        }
        return null;
    }

    public synchronized void show() {
        for(int i = 0; i < getSize(); i++) {
            Product product = productList.get(i);
            System.out.println(product.toString());
        }
    }
}
