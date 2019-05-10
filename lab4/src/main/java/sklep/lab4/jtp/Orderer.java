package sklep.lab4.jtp;


import org.apache.log4j.PropertyConfigurator;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Orderer extends Thread {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Orderer.class);
    private volatile boolean shutdown = false;
    private final int alarmAt = 3;
    private Shop shop;
    private ReentrantLock lock;
    private final int sleepTime;

    public Orderer(Shop shop, int sleepTime, ReentrantLock lock) {
        this.shop = shop;
        this.sleepTime = sleepTime;
        this.lock = lock;
    }

    @Override
    public void run() {
        Supplier supplier = null;
        while (!shutdown) {
            lock.lock();
            String code = shop.getWarehouse().resupplyNeeded(alarmAt);
            if(code != null){
                logger.warn("[Orderer] Resupply needed: " + code);
                System.out.println("[Orderer] Resupply needed: " + code);
                if(shop.getMoney() < 5.00) {
                    logger.warn("[Orderer] Shop too low on money to order");
                    shutdown();
                    if(supplier.isAlive())
                        supplier.interrupt();
                    break;
                }
                if(supplier != null && supplier.isAlive())
                    supplier.interrupt();
                supplier = new Supplier(shop, lock);
                supplier.supply(code);
                supplier.start();
            }
            lock.unlock();
            waitTime(sleepTime);
        }
    }

    private void waitTime(int sleepTime) {
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        shutdown = true;
    }
}
