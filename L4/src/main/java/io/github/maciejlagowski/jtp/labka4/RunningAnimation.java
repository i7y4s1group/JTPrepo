package io.github.maciejlagowski.jtp.labka4;

import org.apache.log4j.Logger;

class RunningAnimation extends Thread {
    //Variables
    private Warehouse warehouse;
    private Logger logger = LoggerClass.getLogger();

    //Methods
    RunningAnimation(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        super.run();
        while (!warehouse.isBlocked()) {
            cls();
            System.out.println("Program running.. \\");
            mySleep();
            cls();
            System.out.println("Program running.. |");
            mySleep();
            cls();
            System.out.println("Program running.. /");
            mySleep();
            cls();
            System.out.println("Program running.. -");
            mySleep();
        }
        System.out.println("Program finished.");
        logger.info("Program finished.");
    }

    private void mySleep() {
        try {
            sleep(500);
        } catch (InterruptedException ex) {
            logger.error(ex.getMessage());
        }
    }

    private void cls() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
