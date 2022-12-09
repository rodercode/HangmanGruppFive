package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Word {

     @FXML
     private TextField userInput;

     @FXML
     private Label wordToGuess;



    public void btn() {
        String word = userInput.getText();
        String hiddenWord = "";
        for (int i = 0; i <word.length() ; i++) {
            hiddenWord = hiddenWord + "*";
        }
        wordToGuess.setText(hiddenWord);
    }


}

