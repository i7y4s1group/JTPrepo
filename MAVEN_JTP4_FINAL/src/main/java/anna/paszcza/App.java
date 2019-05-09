package anna.paszcza;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.concurrent.Semaphore;

public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception
    {
        TextField textField = new TextField();
        Label label = new Label("Wprowadz liczbe klientow: ");
        Group root = new Group();
        StackPane stackPane = new StackPane();
        Button button = new Button("OK");
        textField.setTranslateY(25);
        button.setTranslateY(55);
        textField.setTranslateX(5);
        label.setTranslateX(5);
        stackPane.getChildren().add(label);
        stackPane.getChildren().add(textField);
        stackPane.getChildren().add(button);
        root.getChildren().add(stackPane);
        Scene scene = new Scene(root, 160, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("I7Y4S1 Paszcza Anna");
        primaryStage.show();
        button.setOnMouseClicked((e) ->
        {
            dzialanie(textField.getText(), primaryStage);
        });
    }

    public void dzialanie(String liczba, Stage stage)
    {
        if(czyInt(liczba))
        {
            int liczbaInt = Integer.parseInt(liczba);
            Finanse finanse = new Finanse(true, 10000);
            Produkt produkt1 = new Produkt(3, 1, "jablko", 40);
            Produkt produkt2 = new Produkt(4, 1, "gruszka", 40);
            Produkt produkt3 = new Produkt(5, 1, "winogrono", 50);
            Produkt produkt4 = new Produkt(6, 1, "arbuz", 20);
            Magazyn magazyn = new Magazyn();
            magazyn.dodajNowyProdukt(produkt1);
            magazyn.dodajNowyProdukt(produkt2);
            magazyn.dodajNowyProdukt(produkt3);
            magazyn.dodajNowyProdukt(produkt4);
            Semaphore semafor = new Semaphore(1);
            Semaphore semafor2 = new Semaphore(1);
            Zamowienie zamowienie = new Zamowienie(magazyn, finanse, semafor2 );
            Dostarczenie dostarczenie = new Dostarczenie(magazyn, finanse, semafor2);
            zamowienie.start();
            dostarczenie.start();
            for(int i=0; i<liczbaInt; i++)
            {
                Klient klient = new Klient(magazyn, semafor, i+1, finanse);
                klient.start();
            }
            stage.hide();
        }
    }

    public boolean czyInt(String liczba)
    {
        try
        {
            int liczbaInt = Integer.parseInt(liczba);
            return true;
        }
        catch(NumberFormatException er)
        {
            return false;
        }
    }
}
