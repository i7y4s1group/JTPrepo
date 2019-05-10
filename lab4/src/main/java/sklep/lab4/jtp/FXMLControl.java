package sklep.lab4.jtp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLControl {
    private static Stage primaryStage;
    public TextField clientDelay;
    public TextField ordererDelay;
    public TextField money;
    public TextField clientIterations;

    @FXML
    protected void acceptButtonAction(ActionEvent event) {
        cfg.clientDelay = Integer.parseInt(clientDelay.getText());
        cfg.ordererDelay = Integer.parseInt(ordererDelay.getText());
        cfg.clientIterations = Integer.parseInt(clientIterations.getText());
        cfg.money = Double.parseDouble(money.getText());
        primaryStage.close();
    }

    static void setPrimaryStage(Stage primaryStage) {
        FXMLControl.primaryStage = primaryStage;
    }
}
