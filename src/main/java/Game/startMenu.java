package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Array;

public class startMenu {
    @FXML
    private Label popUpLabel;
    private Database database = Database.getInstance();
    @FXML
    private TextField userInput;

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


    public void startGameButton(ActionEvent actionEvent) {
        if(userInput.getText().equals("")){
            popUpLabel.setText("Incorrect Word");
            System.out.println("Fail");

        } else{
            database.addWord(userInput.getText());
            System.out.println(database.getListOfWords());
            popUpLabel.setText("");
        }
    }
}
