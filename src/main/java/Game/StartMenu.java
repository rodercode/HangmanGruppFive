package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartMenu implements Initializable {

    private Database database;
    private int currentPlayer;

    public StartMenu() {
        database = Database.getInstance();
        currentPlayer = 1;
    }

    @FXML
    private Label popUpLabel;
    @FXML
    private TextField userInput;

    @FXML
    private Label playerPlate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database.createPlayer(4);
        System.out.println(database.getPlayerScores().get(2));
    }

    public boolean checkIfInputIsValid() {
        return !userInput.getText().equals("");
    }

    @FXML
    public void changeScene(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartMenu.class.getResource("GameView.fxml"));
        stage.setTitle("Hangman");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    public void changePlayer() throws IOException {
        if (currentPlayer < 4) {
            currentPlayer++;
            playerPlate.setText("Player " + currentPlayer + ": Enter A Word");
        } else {
//            switchScene
            changeScene(new Stage());
        }
    }

    @FXML
    public void startGameButton(ActionEvent actionEvent) throws IOException {
        if (checkIfInputIsValid()) {
            popUpLabel.setText("");
            database.addWord(currentPlayer, userInput.getText());
            userInput.setText("");
            changePlayer();

        } else {
            popUpLabel.setText("Incorrect Word");
        }
    }

    @FXML
    public void handleButtonPress(ActionEvent event) {
        Button button = (Button) event.getSource();
        userInput.appendText(button.getText());
    }
}


