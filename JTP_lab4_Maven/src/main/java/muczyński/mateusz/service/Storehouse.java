package muczyński.mateusz.service;

import lombok.Getter;
import lombok.Setter;
import muczyński.mateusz.model.Product;
import muczyński.mateusz.model.enums.Category;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Getter
@Setter
public class Storehouse {
    private Map<Category, List<Product>> products;

    public Storehouse(String fileName) {
       products = new HashMap<>();
       getProductsFromFile(fileName);
    }

    public void eraseFromStorehouse(Category category, Product productToErase){
        products.computeIfPresent(category, (key, list) -> eraseProduct(list, productToErase));
    }

    private void getProductsFromFile(String fileName){
        try (
                Stream<String> lines = Files.lines(Paths.get(fileName))
        ){
                lines.forEach(line -> {
                    String[] productData = line.split(";");
                    Product product = createProduct(productData);
                    products.compute(Category.valueOf(productData[0]),
                            (category, list) -> addToList(list, product));
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Product> eraseProduct(List<Product> products, Product productToErase){
        products.remove(productToErase);
        return products;
    }

    private List<Product> addToList(List<Product> products, Product productToAdd){
        if(products == null){
            products = new ArrayList<>();
        }

        products.add(productToAdd);
        return products;
    }

    private Product createProduct(String[] productData){
        BigDecimal price = new BigDecimal(productData[2]);
        Product newProduct = new Product
                .ProductBuilder()
                .setName(productData[1])
                .setPrice(price)
                .setMargin(Double.parseDouble(productData[3]))
                .setDescription(productData[4])
                .build();

        return newProduct;
    }
}
