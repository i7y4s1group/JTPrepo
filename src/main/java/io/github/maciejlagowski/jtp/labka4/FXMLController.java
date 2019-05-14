package io.github.maciejlagowski.jtp.labka4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController {
    //Variables
    private static Stage primaryStage;
    public TextField howManyClientsTB;
    public TextField maxSleepTimeTB;
    public TextField moneyTB;
    public TextField limitTB;
    public Label errLabel;

    //Methods
    @FXML
    protected void handleAcceptButtonAction(ActionEvent event) {
        try {
            Main.config.setHowManyClients(Integer.parseInt(howManyClientsTB.getText()));
            Main.config.setMaxClientDelay(Integer.parseInt(maxSleepTimeTB.getText()));
            Main.config.setMoney(Double.parseDouble(moneyTB.getText()));
            Main.config.setMinQuantity(Integer.parseInt(limitTB.getText()));
            primaryStage.close();
            Main.config.setConfigured(true);
        } catch (NumberFormatException ex) {
            errLabel.setVisible(true);
        }
    }

    static void setPrimaryStage(Stage primaryStage) {
        FXMLController.primaryStage = primaryStage;
    }
}
