package Game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DisplayLetter {


    @FXML
    private TextField userInput;

    @FXML
    private Label wordGuess;



    public void button() {
        String word = userInput.getText();
        String hiddenWord = " ";
        for (int i = 0; i <word.length() ; i++) {
            hiddenWord = hiddenWord + " _ ";
        }
        wordGuess.setText(hiddenWord);
    }
}
