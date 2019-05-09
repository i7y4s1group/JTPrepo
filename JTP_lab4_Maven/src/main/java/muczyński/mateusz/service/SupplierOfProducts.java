package muczyński.mateusz.service;

import lombok.AllArgsConstructor;
import muczyński.mateusz.loggers.LoggerInfo;
import muczyński.mateusz.loggers.LoggerWarn;
import muczyński.mateusz.model.Product;
import muczyński.mateusz.model.enums.Category;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class SupplierOfProducts implements Runnable {
    private Storehouse storehouse;
    private CompanyFinances companyFinances;
    private Semaphore ordering;

    @Override
    public void run() {
        updateStorehouse();
    }

    private void updateStorehouse(){
        File directory = new File("ProductsToBuy");
        File[] files = directory.listFiles();

        for (int i = 0; i < files.length; i++) {
            if(FilenameUtils.isExtension(files[i].getPath(), "csv")){
                loadProductsToStorehouse(files[i]);
            }
        }
        ordering.release();
    }

    private void loadProductsToStorehouse(File file){
        if(!file.exists() && !file.canRead()){
            LoggerWarn.getInstance().warn("PROBLEM Z DOSTEPEM DO PLIKU");
            return;
        }

        try (
                Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim())
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                Category category = Category.valueOf(csvRecord.get("category"));
                String name = csvRecord.get("name");
                BigDecimal price = new BigDecimal(csvRecord.get("price"));
                String value;
                double margin = Double.parseDouble(csvRecord.get("margin"));
                String description = csvRecord.get("description");

                Product product = new Product.ProductBuilder()
                        .setName(name)
                        .setPrice(price)
                        .setMargin(margin)
                        .setDescription(description)
                        .build();

                if(companyFinances.expense(price)){
                    LoggerInfo.getInstance().info("DOSTARCZAM PRODUKT: " + product);
                    List<Product> productList = storehouse.getProducts().get(category);
                    productList.add(product);
                }
                else {
                    LoggerWarn.getInstance().warn("NIE MOGE DOSTARCZYC PRODUKTU: " + product + " -> BRAK WYSTARCZAJACEJ ILOSCI SRODKOW NA KONCIE " + companyFinances.getBudget());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.delete();
    }
}
