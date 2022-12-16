package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreViewControl implements Initializable {
    @FXML
    private Button nextButton;
    @FXML
    private Button newGameButton;
    private Database database;
    @FXML
    private Label player1Score;
    @FXML
    private Label player2Score;

    public ScoreViewControl() {
        database = Database.getInstance();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database.createPlayer(2);
        player1Score.setText("Player 1 score: "+ database.getPlayerScores().get(1));
        player2Score.setText("Player 2 score: "+ database.getPlayerScores().get(2));
    }
    public void switchGameScene() throws IOException {
        Parent root = FXMLLoader.load(GameViewControl.class.getResource("startMenu.fxml"));
        Stage window = (Stage) nextButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void pressedButton() throws IOException {
        switchGameScene();
        if (database.getCurrentPlayer() > database.getAmountOfPlayers()) {
        }
    }


}
