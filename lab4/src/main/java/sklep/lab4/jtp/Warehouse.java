package sklep.lab4.jtp;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse {
    private HashMap<String, ProductList> stock = new HashMap<String, ProductList>();

    public HashMap<String, ProductList> getStock() {
        return stock;
    }

    public synchronized String resupplyNeeded(int alarmAt) {
        ArrayList<String> keysAsArray = new ArrayList<String>(stock.keySet());
        for(int i = 0; i < stock.size(); i++){
            ProductList productList = stock.get(keysAsArray.get(i));
            if(productList.getSize() < alarmAt) {
                return keysAsArray.get(i);
            }
        }
        return null;
    }

    public int getSize() {
        int size = 0;
        for (HashMap.Entry<String, ProductList> entry : stock.entrySet()) {
            size += entry.getValue().getSize();
        }
        return size;
    }

    public void readProducts(String productsCsvPath) {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(productsCsvPath));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("Code", "Name", "Price", "Description")
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                String code = csvRecord.get("Code");
                String name = csvRecord.get("Name");
                String price = csvRecord.get("Price");
                String description = csvRecord.get("Description");

                addToStock(code, assembleProduct(name, Double.valueOf(price), description));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Product assembleProduct(String name, double price, String description) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .description(description)
                .build();
        return product;
    }

    public synchronized void addToStock(String code, Product product) {
        if(!stock.containsKey(code)) {
            ProductList productList = new ProductList();
            stock.put(code, productList);
        }
        stock.get(code).getList().add(product);
    }

    public synchronized void showStock() {
        for (HashMap.Entry<String, ProductList> entry : stock.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().show();
        }
    }

    public synchronized Product findProduct(String productName) {
        Product product;
        for (HashMap.Entry<String, ProductList> entry : stock.entrySet()) {
            if((product = entry.getValue().findProduct(productName)) != null)
                return product;
        }
        return null;
    }

    public synchronized void remove(Product product) {
        for (HashMap.Entry<String, ProductList> entry : stock.entrySet()) {
            if((entry.getValue().findProduct(product)) != null)
                entry.getValue().getList().remove(product);
        }
    }

}
