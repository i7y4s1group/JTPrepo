package muczyński.mateusz.service;

import lombok.AllArgsConstructor;
import muczyński.mateusz.loggers.LoggerInfo;
import muczyński.mateusz.loggers.LoggerWarn;
import muczyński.mateusz.model.Product;
import muczyński.mateusz.model.enums.Category;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class OrderService implements Runnable{
    private final Map<Category, List<Product>> initialProducts;
    private Storehouse storehouse;
    private CompanyFinances companyFinances;
    private Semaphore ordering;


    @Override
    public void run() {
        SupplierOfProducts supplierOfProducts;
        storehouse.getProducts().forEach(this::whatToBuy);

        supplierOfProducts = new SupplierOfProducts(storehouse, companyFinances, ordering);
        Thread thread = new Thread(supplierOfProducts);
        thread.start();
    }

    private void whatToBuy(Category category, List<Product> products){
        List<Product> productsToBuy = new ArrayList<>(initialProducts.get(category));
        productsToBuy.removeAll(products);
        safeToCSVFile(category, productsToBuy);
    }

    private void safeToCSVFile(Category category, List<Product> productsToBuy){

        String fileName = createFileName();

        try(
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("category","name", "price", "margin", "description"))
         ){

            for(Product product : productsToBuy){
                LoggerInfo.getInstance().info("ZAMAWIAM TOWAR: " + category + " " + product);
                csvPrinter.printRecord(category, product.getName(), product.getPrice(), product.getMargin(), product.getDescription());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createFileName(){
        createDir();

        String fileName = "ProductsToBuy\\productsToBuy.csv";
        File file = new File(fileName);
        int i = 1;

        while(file.exists()){
            fileName = "ProductsToBuy\\productsToBuy(" + (i++) + ").csv";
            file = new File(fileName);
        }
        return fileName;
    }

    private void createDir(){
        File directory = new File("ProductsToBuy");

        if(!directory.exists()){
            directory.mkdir();
        }
    }
}
