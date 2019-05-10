package los.przemyslaw;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class App extends Application {
    private static String budzetFirmy;
    private static String iloscKlientow;
    public static void main( String[] args )
    {
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception
    {
        TextField liczba = new TextField();
        TextField budzet = new TextField();
        Label label = new Label("Wprowadz liczbe klientow: ");
        Label label2 = new Label("Wprowadz budzet firmy: ");
        Group root = new Group();
        StackPane stackPane = new StackPane();
        Button button = new Button("OK");
        liczba.setTranslateY(25);
        budzet.setTranslateY(90);
        label2.setTranslateY(60);
        button.setTranslateY(160);
        budzet.setTranslateX(20);
        liczba.setTranslateX(20);
        label.setTranslateX(20);
        label2.setTranslateX(20);
        stackPane.getChildren().add(label);
        stackPane.getChildren().add(label2);
        stackPane.getChildren().add(liczba);
        stackPane.getChildren().add(budzet);
        stackPane.getChildren().add(button);
        root.getChildren().add(stackPane);
        Scene scene = new Scene(root, 230, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Przemyslaw Los I7Y4S1");
        primaryStage.show();
        budzetFirmy = budzet.getText();
        iloscKlientow = liczba.getText();


    }
}
