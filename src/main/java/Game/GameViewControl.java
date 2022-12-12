package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameViewControl {


    public void buttonQ() {
        userInput.appendText("Q");
    }
    public void buttonW() {
        userInput.appendText("W");
    }
    public void buttonE() {
        userInput.appendText("E");
    }
    public void buttonR() {
        userInput.appendText("R");
    }

    @FXML
    private TextField userInput;

    @FXML
    private Label wordGuess;

    @FXML
    public void button() {
        String word = userInput.getText();
        String hiddenWord = " ";
        for (int i = 0; i <word.length() ; i++) {
            hiddenWord = hiddenWord + " _ ";
        }
        wordGuess.setText(hiddenWord);
    }




//    public void enterButton() {
//        String word = userInput.getText();
//        String hiddenWord = "";
//        for (int i = 0; i <word.length() ; i++) {
//            hiddenWord = hiddenWord + "*";
//        }
//        wordToGuess.setText(hiddenWord);
//    }
}
