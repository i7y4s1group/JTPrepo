package sklep.lab4.jtp;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;

public class DataGen {

    private volatile static HashMap<String, Integer> counter = new HashMap<String, Integer>();
    private Random random = new Random();

    public DataGen() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(FileInfo.productsFilePath));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("Code", "Name", "Price", "Description")
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                String code = csvRecord.get("Code");
                addToCounter(code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product getNewProduct(String code) {
        String name;
        Double price;
        String description;

        name = code.substring(0,1).toUpperCase() + code.substring(1).toLowerCase() + " " + counter.get(code);
        description = name + " description";
        price = (random.nextInt(8) + random.nextInt(100)/100.0) + 1;

        price = BigDecimal.valueOf(price)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        Product product = Product.builder()
                .name(name)
                .price(price)
                .description(description)
                .build();

        int tmp = counter.get(code);
        tmp += 1;
        counter.put(code, tmp);

        return product;
    }

    private void addToCounter(String code) {
        if(!counter.containsKey(code)) {
            counter.put(code, 0);
        }
        int tmp = counter.get(code);
        tmp++;
        counter.put(code, tmp);
    }
}
