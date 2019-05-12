import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import muczyński.mateusz.windows.StageContainer;

@Getter
public class StartingWindow extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageContainer.primaryStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("welcomeWindow.fxml"));
        primaryStage.setTitle("Symulator sklepu");
        primaryStage.setScene(new Scene(root, 344, 251));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
