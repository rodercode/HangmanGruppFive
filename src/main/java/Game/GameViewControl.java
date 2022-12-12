package Game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameViewControl implements Initializable {

   private Database data;



   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      currentPlayer.setAlignment(Pos.CENTER);
      wordGuess.setAlignment(Pos.CENTER);
      mistake.setAlignment(Pos.CENTER);
      data.getListOfWords();

   }
   public GameViewControl() {
      data = Database.getInstance();
   }

   @FXML
   private Label currentPlayer;
   @FXML
   private TextField userInput;
   @FXML
   private Label wordGuess;
   @FXML
   private Label mistake;

   @FXML
   public void button() {
      String word = data.getListOfWords().get(2);
      StringBuilder hiddenWord = new StringBuilder(" ");
      for (int i = 0; i <word.length() ; i++) {
         hiddenWord.append(" _ ");
      }
      userWordGuess();
      wordGuess.setText(hiddenWord.toString());
   }

   public void userWordGuess () {
      String word = data.getListOfWords().get(2);
      if (userInput.getText().equals(word)) {
         System.out.println("Funkade :D");
      } else {
       /*int count = 0;
         count++;
         mistake.setText(count); */
         System.out.println("Fel");
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

