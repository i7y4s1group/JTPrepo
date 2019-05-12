package muczyński.mateusz.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import muczyński.mateusz.menu.MenuService;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField numberOfClients;
    @FXML
    private TextField time;

    @FXML
    private void nextButtonController(ActionEvent actionEvent) throws IOException {
        MenuService menuService;
        int time = takeTime();
        int numberOfClients = takeNumberOfClients();
        Scene primaryScene = StageContainer.primaryStage.getScene();

        if(numberOfClients != -1 && time != -1){
            menuService = new MenuService(numberOfClients, time);

            StageContainer.primaryStage.close();
            menuService.runApp();
        }
    }

    private int takeNumberOfClients(){
        if(numberOfClients != null && !isTextFieldEmpty(numberOfClients) && textFieldContainsPositiveNumber(numberOfClients)){
            return Integer.parseInt(numberOfClients.getText());
        }
        return -1;
    }

    private int takeTime(){
        if(time != null && !isTextFieldEmpty(time) && textFieldContainsPositiveNumber(time)){
            return Integer.parseInt(time.getText());
        }
        return -1;
    }

    private boolean isTextFieldEmpty(TextField label){
        if(label == null){
            return false;
        }
        return label.getText().isEmpty();
    }

    private boolean textFieldContainsPositiveNumber(TextField label){

        if (label == null){
            return false;
        }
        return label.getText().matches("[1-9][0-9]*");
    }
}
