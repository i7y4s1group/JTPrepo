package sklep.lab4.jtp;

import org.apache.log4j.PropertyConfigurator;

import java.util.concurrent.locks.ReentrantLock;

public class Supplier extends Thread {
    private volatile boolean shutdown = false;
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Supplier.class);
    private volatile String code = null;
    private Shop shop;
    private static DataGen dataGen = new DataGen();
    private ReentrantLock lock;

    public Supplier(Shop shop, ReentrantLock lock) {
        this.shop = shop;
        this.lock = lock;
    }

    public void shutdown() {
        shutdown = true;
    }

    @Override
    public void run() {
        lock.lock();
        while(!shutdown) {
            if(code != null) {
                if(shop.getMoney() < 5.00) {
                    logger.warn("[Supplier] Shop too low on money to resupply");
                    shutdown();
                    shop.shutdown();
                    continue;
                }
                Product product = dataGen.getNewProduct(code);
                System.out.println("[Supplier] Adding to stock: ");
                System.out.println(product);
                logger.info("[Supplier] Adding to stock: " + product.toString());
                shop.setMoney(shop.getMoney() - product.getPrice());
                shop.getWarehouse().addToStock(code, product);
                break;
            }
        }
        lock.unlock();
    }

    public void supply(String code) {
        this.code = code;
    }
}
