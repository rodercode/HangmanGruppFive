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
    public Button ExitButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button newGameButton;

    private Database database;
    @FXML
    private Label player1Score;
    @FXML
    private Label player2Score;
    @FXML
    private Label winnerText;

    public ScoreViewControl() {
        database = Database.getInstance();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player1Score.setText("Player 1 score: "+ database.getPlayerScores().get(1));
        player2Score.setText("Player 2 score: "+ database.getPlayerScores().get(2));
        maxScore();
    }
    public void switchGameScene() throws IOException {
        Parent root = FXMLLoader.load(ScoreViewControl.class.getResource("startMenu.fxml"));
        Stage window = (Stage) nextButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void maxScore(){
        if(database.getPlayerScores().get(1) == 10 ){
            winnerText.setText("CONGRATULATIONS PLAYER 1! YOU WON");
        } else if (database.getPlayerScores().get(2) == 10) {
            winnerText.setText("CONGRATULATIONS PLAYER 2! YOU WON");
        }
    }
    public void pressedButton() throws IOException {
        switchGameScene();
        if (database.getCurrentPlayer() > database.getAmountOfPlayers()) {
        }
    }

    public void exitButton() {
        System.exit(0);
            }

}
