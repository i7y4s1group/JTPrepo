package muczyński.mateusz.service;

import lombok.AllArgsConstructor;
import muczyński.mateusz.loggers.LoggerInfo;
import muczyński.mateusz.loggers.LoggerWarn;
import muczyński.mateusz.model.Product;
import muczyński.mateusz.model.enums.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;


@AllArgsConstructor
public class ClientService implements Runnable{
    private final int NUMBER_OF_PRODUCT_TO_BUY = 3;
    private final int MINIMUM_BUDGET = 60;
    private int time;
    private Storehouse storehouse;
    private Semaphore iAmBuying;
    private int id;
    private CompanyFinances companyFinances;


    @Override
    public void run() {
        Random draw = new Random();

        while(companyFinances.getBudget().compareTo(BigDecimal.valueOf(MINIMUM_BUDGET)) > 0){ //poprawic
            wait(draw.nextInt(time) + 1000);

            semaphoreDown(iAmBuying);
            for (int i = 0; i < NUMBER_OF_PRODUCT_TO_BUY; i++) {
                Category category = randCategory();
                Product product = randProduct(category);

                if(product != null) {
                    storehouse.eraseFromStorehouse(category, product);
                    LoggerInfo.getInstance().info("KLIENT " + id + " KUPUJE " + category + " " + product);
                }
                else {
                    LoggerWarn.getInstance().warn("KLIENT USILUJE KUPIC PRODUKT CHWILOWO NIEDOSTEPNY: " + category + " " + product);
                }
            }
            semaphoreUp(iAmBuying);
        }
    }

    private void semaphoreDown(Semaphore semaphore){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void semaphoreUp(Semaphore semaphore){
        semaphore.release();
    }

    private void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Category randCategory(){
        Category[] categories = Category.values();
        Random draw = new Random();

        return categories[draw.nextInt(categories.length)];
    }

    private Product randProduct(Category category){
        List<Product> drewProducts = storehouse.getProducts().get(category);
        Random draw = new Random();

        if(drewProducts.isEmpty()){
            return null;
        }

        return drewProducts.get(draw.nextInt(drewProducts.size()));
    }
}
