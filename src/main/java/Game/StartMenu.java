package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
        database.createPlayer(2);
        System.out.println(database.getPlayerScores().get(2));
    }
    public boolean checkIfInputIsValid() {
        return !userInput.getText().equals("");
    }
    @FXML
    public void changeScene(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("GameView.fxml"));
        stage.setTitle("Hangman");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }
    public void changePlayer() throws IOException {
        if (currentPlayer <2){
            currentPlayer++;
            playerPlate.setText("Player " + currentPlayer + ": Enter A Word");
        }else {
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
        public void buttonQ () {
            userInput.appendText("Q");
        }

        @FXML
        public void buttonW () {
            userInput.appendText("W");
        }

        @FXML
        public void buttonE () {
            userInput.appendText("E");
        }

        @FXML
        public void buttonR () {
            userInput.appendText("R");
        }

        @FXML
        public void buttonT () {
            userInput.appendText("T");
        }

        @FXML
        public void buttonY () {
            userInput.appendText("Y");
        }

        @FXML
        public void buttonU () {
            userInput.appendText("U");
        }

        @FXML
        public void buttonI () {
            userInput.appendText("I");
        }

        @FXML
        public void buttonO () {
            userInput.appendText("O");
        }

        @FXML
        public void buttonP () {
            userInput.appendText("P");
        }

        @FXML
        public void buttonÅ () {
            userInput.appendText("Å");
        }

        @FXML
        public void buttonA () {
            userInput.appendText("A");
        }

        @FXML
        public void buttonS () {
            userInput.appendText("S");
        }

        @FXML
        public void buttonD () {
            userInput.appendText("D");
        }

        @FXML
        public void buttonF () {
            userInput.appendText("F");
        }

        @FXML
        public void buttonG () {
            userInput.appendText("G");
        }

        @FXML
        public void buttonH () {
            userInput.appendText("H");
        }

        @FXML
        public void buttonJ () {
            userInput.appendText("J");
        }

        @FXML
        public void buttonK () {
            userInput.appendText("K");
        }

        @FXML
        public void buttonL () {
            userInput.appendText("L");
        }

        @FXML
        public void buttonÖ () {
            userInput.appendText("Ö");
        }

        @FXML
        public void buttonÄ () {
            userInput.appendText("Ä");
        }

        @FXML
        public void buttonZ () {
            userInput.appendText("Z");
        }

        @FXML
        public void buttonX () {
            userInput.appendText("X");
        }

        @FXML
        public void buttonC () {
            userInput.appendText("C");
        }

        @FXML
        public void buttonV () {
            userInput.appendText("V");
        }

        @FXML
        public void buttonB () {
            userInput.appendText("B");
        }

        @FXML
        public void buttonN () {
            userInput.appendText("N");
        }

        @FXML
        public void buttonM () {
            userInput.appendText("M");
        }

    }


