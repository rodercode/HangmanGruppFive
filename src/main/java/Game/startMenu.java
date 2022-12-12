package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;

public class startMenu implements Initializable {

    private Database database;
    private int currentPlayer;

    public startMenu() {
        database = Database.getInstance();
        currentPlayer = 1;
    }

    @FXML
    public void pressPlayBtn() throws IOException {
        enterWord();
        if (data.getListOfWords().size() == 2) {

        }
    }

    public void changePlayer() throws IOException {
        player.setText("Player Two: Enter A Word");
        userInput.setText("");
    }



    public boolean checkIfInputIsValid() {
        return !userInput.getText().equals("");
    }



    @FXML
    private Label popUpLabel;
    @FXML
    private TextField userInput;

    @FXML
    private Label Player;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database.getListOfWords();
    }

    public void enterWord() throws IOException {
        if (checkIfInputIsValid()) {
            data.addWord(userInput.getText().toLowerCase());
            changePlayer();
        } else {
            popUpLabel.setText("Incorrect Word");
            System.out.println("Fail");
        }
    }
    @FXML
    public void startGameButton(ActionEvent actionEvent) {

        if(checkIfInputIsValid()){
            popUpLabel.setText("Incorrect Word");
            System.out.println("Fail");

        } else{
            database.addWord(currentplayer,userInput.getText());
           // test
            database.getListOfWords();
            Player.setText("Player 2: Enter Word");
            userInput.setText("");
            currentplayer++;
            System.out.println(currentplayer);
        }
    }
    @FXML
    public void buttonQ() {
        userInput.appendText("Q");
    }
    @FXML
    public void buttonW() {
        userInput.appendText("W");
    }
    @FXML
    public void buttonE() {
        userInput.appendText("E");
    }
    @FXML
    public void buttonR() {
        userInput.appendText("R");
    }
    @FXML
    public void buttonT() {
        userInput.appendText("T");
    }
    @FXML
    public void buttonY() {
        userInput.appendText("Y");
    }
    @FXML
    public void buttonU() {
        userInput.appendText("U");
    }
    @FXML
    public void buttonI() {
        userInput.appendText("I");
    }
    @FXML
    public void buttonO() {
        userInput.appendText("O");
    }
    @FXML
    public void buttonP() {
        userInput.appendText("P");
    }
    @FXML
    public void buttonÅ() {
        userInput.appendText("Å");
    }
    @FXML
    public void buttonA() {
        userInput.appendText("A");
    }
    @FXML
    public void buttonS() {
        userInput.appendText("S");
    }
    @FXML
    public void buttonD() {
        userInput.appendText("D");
    }
    @FXML
    public void buttonF() {
        userInput.appendText("F");
    }
    @FXML
    public void buttonG() {
        userInput.appendText("G");
    }
    @FXML
    public void buttonH() {
        userInput.appendText("H");
    }
    @FXML
    public void buttonJ() {
        userInput.appendText("J");
    }
    @FXML
    public void buttonK() {
        userInput.appendText("K");
    }
    @FXML
    public void buttonL() {
        userInput.appendText("L");
    }
    @FXML
    public void buttonÖ() {
        userInput.appendText("Ö");
    }
    @FXML
    public void buttonÄ() {
        userInput.appendText("Ä");
    }
    @FXML
    public void buttonZ() {
        userInput.appendText("Z");
    }
    @FXML
    public void buttonX() {
        userInput.appendText("X");
    }
    @FXML
    public void buttonC() {
        userInput.appendText("C");
    }
    @FXML
    public void buttonV() {
        userInput.appendText("V");
    }
    @FXML
    public void buttonB() {
        userInput.appendText("B");
    }
    @FXML
    public void buttonN() {
        userInput.appendText("N");
    }
    @FXML
    public void buttonM() {
        userInput.appendText("M");
    }
}

