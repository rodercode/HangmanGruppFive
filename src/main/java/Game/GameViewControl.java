package Game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GameViewControl implements Initializable {

   private Database data;

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      System.out.println(data.getListOfWords());
   }

   public GameViewControl() {
      data = Database.getInstance();
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
}





//    public void enterButton() {
//        String word = userInput.getText();
//        String hiddenWord = "";
//        for (int i = 0; i <word.length() ; i++) {
//            hiddenWord = hiddenWord + "*";
//        }
//        wordToGuess.setText(hiddenWord);
//    }

