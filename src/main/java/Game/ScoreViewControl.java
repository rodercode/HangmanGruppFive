package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ScoreViewControl {
    @FXML
    private Button nextButton;
    private Database database;

    public ScoreViewControl() {
        database = Database.getInstance();
    }
    public void switchGameScene(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(GameViewControl.class.getResource("GameView.fxml"));
        Stage window = (Stage) nextButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void pressedButton(ActionEvent actionEvent) throws IOException {
        switchGameScene(actionEvent);
    }
}
