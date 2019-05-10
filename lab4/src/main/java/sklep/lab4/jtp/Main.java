package sklep.lab4.jtp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

        Shop shop = new Shop(cfg.money);
        Client client = new Client(shop, cfg.clientDelay, cfg.clientIterations);
        Orderer orderer = new Orderer(shop, cfg.ordererDelay, shop.lock);

        shop.setThreads(client, orderer);
        shop.start();

        try {
            client.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            orderer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/jfxConf.fxml"));
        primaryStage.setTitle("Sklep");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        FXMLControl.setPrimaryStage(primaryStage);
        primaryStage.show();
    }
}
