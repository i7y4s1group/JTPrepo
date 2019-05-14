package io.github.maciejlagowski.jtp.labka4;

/**
 * @author Maciej Łagowski
 * JTP lab4 - aplikacja biznesowa
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Main extends Application {

    static Config config = new Config();

    public static void main(String[] args) {
        launch(args);
        if (config.isConfigured()) {
            Warehouse warehouse = new Warehouse();
            warehouse.insertProductsInWarehouse(CsvClass.makeObjectsFromCsv());
            warehouse.showWarehouse();
            new Order(warehouse).start();
            for (int i = 1; i <= config.getHowManyClients(); i++) {
                try {
                    new Client(warehouse, i).start();
                } catch (IOException ex) {
                    Logger logger = LoggerClass.getLogger();
                    logger.error("Can't create output csv files");
                    warehouse.block();
                }
            }
            new RunningAnimation(warehouse).run();
        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/jfxConf.fxml"));
        primaryStage.setTitle("Maciej Łagowski JTP l4");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        FXMLController.setPrimaryStage(primaryStage);
        primaryStage.show();
    }
}
