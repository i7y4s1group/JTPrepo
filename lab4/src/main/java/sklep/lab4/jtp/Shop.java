package sklep.lab4.jtp;

import org.apache.log4j.PropertyConfigurator;

import java.util.concurrent.locks.ReentrantLock;

public class Shop {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Shop.class);
    private Warehouse warehouse = new Warehouse();
    private double money;
    private double profit = 0;
    static ReentrantLock lock = new ReentrantLock();
    private Client client;
    private Orderer orderer;
    private Supplier supplier;

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void shutdown() {
        if(client.isAlive())    client.shutdown();
        if(orderer.isAlive())   orderer.shutdown();
        if(supplier.isAlive())  supplier.shutdown();
        showState();
        logger.info("[Shop] Shop shutdown");
    }

    public void start() {
        showState();
        client.start();
        orderer.start();
    }

    public void setThreads(Client client, Orderer orderer) {
        this.client = client;
        this.orderer = orderer;
    }

    public Shop(double money) {
        warehouse.readProducts(FileInfo.productsFilePath);
        this.money = money;
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public synchronized void sell(String productName) {
        Product product = warehouse.findProduct(productName);
        if(product == null)
            throw new IllegalArgumentException("Product not found");

        profit += product.getPrice();
        warehouse.remove(product);

        String code;
        while((code = warehouse.resupplyNeeded(1)) != null) {
            lock.lock();
            supplier = new Supplier(this, lock);
            supplier.supply(code);
            supplier.start();
            lock.unlock();
        }
    }

    public synchronized void showState() {
        System.out.println("Shop state: ");
        warehouse.showStock();
        System.out.println("Money: " + money);
        System.out.println("Profit: " + profit);
    }
}
