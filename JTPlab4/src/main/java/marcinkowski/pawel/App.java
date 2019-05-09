package marcinkowski.pawel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class App extends Application{
private static String iloscKlientow;
private static String budzetFirmy;
private static Log log = new Log();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/GUI.fxml"));
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 300, 275));



        Button przycisk = (Button)primaryStage.getScene().lookup("#przycisk");
        przycisk.setOnMouseClicked((e)->{

            TextField liczba = (TextField) primaryStage.getScene().lookup("#liczba");
            iloscKlientow = liczba.getText();

            TextField budzet = (TextField) primaryStage.getScene().lookup("#budzet");
            budzetFirmy = liczba.getText();
            Sklep sklep = new Sklep(Integer.valueOf(iloscKlientow), Integer.valueOf(budzetFirmy));
            try {
                sklep.prowadzenieSklepu();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            primaryStage.hide();
        });
        primaryStage.show();
    }

    public static void main( String[] args ) throws FileNotFoundException {
        log.Informacje();
        launch(args);
    }
}
