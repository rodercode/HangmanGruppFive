package Game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


import java.util.ResourceBundle;

public class GameViewControl implements Initializable {

    // Variables
    private Database data;
    private int remainingGuesses;
    private char[] hiddenWord;

    // FXML variables
    @FXML
    private Label currentPlayer;
    @FXML
    private TextField userInput;
    @FXML
    private Label wordGuess;
    @FXML
    private Label mistake;
    @FXML
    private ImageView imageViewCake;

    public GameViewControl() throws FileNotFoundException {
        data = Database.getInstance();
        remainingGuesses = 11;
        hiddenWord = generateHiddenWord();
    }

    // Start method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wordGuess.setAlignment(Pos.CENTER);
        wordGuess.setText(displayHiddenWord());
        imageViewCake.setImage(imageCake12);
    }
    public char[] generateHiddenWord(){
        String theWord = data.getListOfWords().get(2);
        char[] hiddenWord = new char[theWord.length()];
        Arrays.fill(hiddenWord, '_');
        return hiddenWord;
    }

    public String displayHiddenWord() {
        char[] hiddenWord = generateHiddenWord();
        String newWord = String.valueOf(hiddenWord);
        return newWord.replace(""," ").trim();
    }

    public void checkIfLetterExist(char letter,String guessWord) {
        for (int i = 0; i < hiddenWord.length ; i++) {
            if (guessWord.charAt(i) == letter){
                hiddenWord[i] = letter;
            }
        }
        String newHiddenWord = String.valueOf(hiddenWord);
        wordGuess.setText(newHiddenWord.replace(""," ").trim());
    }


    @FXML
    public void pressEnter() {
        String word = data.getListOfWords().get(2);
        if (userInput.getText().toUpperCase().equals(word)) {
            System.out.println("Funkade :D");
        } else {
       /*int count = 0;
         count++;
         mistake.setText(count); */
            System.out.println("Fel");
        }
        userInput.setText("");
    }

    // Cake animation
    @FXML
    public void displayCakeImage() {
        if (remainingGuesses == 11)
            imageViewCake.setImage(imageCake11);
        else if (remainingGuesses == 10)
            imageViewCake.setImage(imageCake10);
        else if (remainingGuesses == 9)
            imageViewCake.setImage(imageCake9);
        else if (remainingGuesses == 8)
            imageViewCake.setImage(imageCake8);
        else if (remainingGuesses == 7)
            imageViewCake.setImage(imageCake7);
        else if (remainingGuesses == 6)
            imageViewCake.setImage(imageCake6);
        else if (remainingGuesses == 5)
            imageViewCake.setImage(imageCake5);
        else if (remainingGuesses == 4)
            imageViewCake.setImage(imageCake4);
        else if (remainingGuesses == 3)
            imageViewCake.setImage(imageCake3);
        else if (remainingGuesses == 2)
            imageViewCake.setImage(imageCake2);
        else if (remainingGuesses == 1)
            imageViewCake.setImage(imageCake1);
        else if (remainingGuesses == 0)
            imageViewCake.setImage(imageCake0);
        remainingGuesses--;
    }
    // End of Cake Animation


    // Letter buttons
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

    // end of Letter buttons

    // Images
    Image imageCake12 = new Image(new FileInputStream("src/main/resources/IMG/Cake12.png"));
    Image imageCake11 = new Image(new FileInputStream("src/main/resources/IMG/Cake11.png"));

    Image imageCake10 = new Image(new FileInputStream("src/main/resources/IMG/Cake10.png"));

    Image imageCake9 = new Image(new FileInputStream("src/main/resources/IMG/Cake9.png"));

    Image imageCake8 = new Image(new FileInputStream("src/main/resources/IMG/Cake8.png"));

    Image imageCake7 = new Image(new FileInputStream("src/main/resources/IMG/Cake7.png"));

    Image imageCake6 = new Image(new FileInputStream("src/main/resources/IMG/Cake6.png"));

    Image imageCake5 = new Image(new FileInputStream("src/main/resources/IMG/Cake5.png"));

    Image imageCake4 = new Image(new FileInputStream("src/main/resources/IMG/Cake4.png"));

    Image imageCake3 = new Image(new FileInputStream("src/main/resources/IMG/Cake3.png"));

    Image imageCake2 = new Image(new FileInputStream("src/main/resources/IMG/Cake2.png"));

    Image imageCake1 = new Image(new FileInputStream("src/main/resources/IMG/Cake1.png"));

    Image imageCake0 = new Image(new FileInputStream("src/main/resources/IMG/Cake0.png"));

    // end of Images
}

