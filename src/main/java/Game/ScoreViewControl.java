package Game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class ScoreViewControl {
    @FXML
    private Button nextButton;

    private Database database;

    public ScoreViewControl() {
        database = Database.getInstance();
    }
    //GameViewControl gameViewControl;
    public void switchGame() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameViewControl.class.getResource("GameView.fxml")));
        Stage window = (Stage) nextButton.getScene().getWindow();
        //gameViewControl.switchPlayer();
        window.setScene(new Scene(root));
    }
}

