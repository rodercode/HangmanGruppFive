package Game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.util.ResourceBundle;

public class GameViewControl implements Initializable {

    // Variables
    private Database database;
    private int mistakes;
    private char[] encryptedWord;
    private int currentPlayer;
    private String theWord;
    private int enemyPlayer;
    private boolean didIScore;

    private boolean isAnswerCorrect;
    private boolean isItGameOver;

    // FXML variables
    @FXML
    private Label playerPlate;
    @FXML
    private TextField userInput;
    @FXML
    private Label wordGuess;
    @FXML
    private Label mistakePlate;
    @FXML
    private ImageView imageViewCake;
    @FXML
    private Label scorePlate;

    @FXML
    private Button enter;

    public GameViewControl() throws FileNotFoundException {
        database = Database.getInstance();
        enemyPlayer = 2;
        theWord = database.getListOfWords().get(enemyPlayer);
        encryptedWord = new char[theWord.length()];
        mistakes = 0;
        isAnswerCorrect = false;
        currentPlayer = 1;
    }

    // Start method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database.setDidIScore(false);
        database.setItGameOver(false);
        database.createPlayer(2);
        wordGuess.setAlignment(Pos.CENTER);
        wordGuess.setText(displayHiddenWord());
        imageViewCake.setImage(imageCake10);
        playerPlate.setText("Player " + currentPlayer + "'s Turn");
    }


    public void switchPlayer() {
        currentPlayer++;
        mistakes = 0;
        playerPlate.setText("Player " + currentPlayer + "'s Turn");
        scorePlate.setText("Score: " + database.getPlayerScores().get(2));
        switchTheWord();
        if (currentPlayer < 5) {
            //Start menu. 
        }
    }
    // switch from player 2 to Player 1's word
    public void switchTheWord() {
        theWord = database.getListOfWords().get(1);
        encryptedWord = new char[theWord.length()];
        wordGuess.setText(displayHiddenWord());
    }

    public char[] generateHiddenWord() {
        Arrays.fill(encryptedWord, '_');
        return encryptedWord;
    }

    public String displayHiddenWord() {
        String newWord = String.valueOf(generateHiddenWord());
        return newWord.replace("", " ").trim();
    }

    public void checkGuess(char letter, String guessWord) {
        for (int i = 0; i < encryptedWord.length; i++) {
            if (guessWord.charAt(i) == letter) {
                System.out.println(guessWord.charAt(i));
                System.out.println(letter);
                encryptedWord[i] = letter;
                isAnswerCorrect = true;
            }
        }
        checkAnswer();
        String newHiddenWord = String.valueOf(encryptedWord);
        wordGuess.setText(newHiddenWord.replace("", " ").trim());
    }

    public void checkAnswer() {
        if (isAnswerCorrect) {
            correctAnswer();
        } else {
            makeAMistake();
        }
    }

    public void makeAMistake() {
        mistakes++;
        displayCakeImage();
        if (mistakes == 10) {
            enter.setText("Next");
            database.setItGameOver(true);
        }

        mistakePlate.setText("Mistake: " + mistakes + "/10");
    }

    public void correctAnswer() {
        isAnswerCorrect = false;
        getPoint();
    }

    public void getPoint() {
        String s = String.valueOf(encryptedWord);
        if (s.equals(theWord)) {
            enter.setText("Next");
            database.addScore(currentPlayer);
            scorePlate.setText("Score: " + database.getPlayerScores().get(currentPlayer));
            database.setDidIScore(true);
        }
    }

    public void switchGameScene() throws IOException {
        Parent root = FXMLLoader.load(GameViewControl.class.getResource("ScoreView.fxml"));
        Stage window = (Stage) enter.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void pressEnter() throws IOException {
        String s = String.valueOf(encryptedWord);
        if (userInput.getText().toUpperCase().equals(theWord)) {
            userInput.setText("");
            database.addScore(currentPlayer);
            scorePlate.setText("Score: " + database.getPlayerScores().get(currentPlayer));
            switchPlayer();
            System.out.println("You get a point");
        } else if (database.isItGameOver()|| database.isDidIScore()) {
            switchGameScene();
        }
        userInput.setText("");
        System.out.println("Fel");
    }


    // Cake animation
    @FXML
    public void displayCakeImage() {
        if (mistakes == 1)
            imageViewCake.setImage(imageCake9);
        else if (mistakes == 2)
            imageViewCake.setImage(imageCake8);
        else if (mistakes == 3)
            imageViewCake.setImage(imageCake7);
        else if (mistakes == 4)
            imageViewCake.setImage(imageCake6);
        else if (mistakes == 5)
            imageViewCake.setImage(imageCake5);
        else if (mistakes == 6)
            imageViewCake.setImage(imageCake4);
        else if (mistakes == 7)
            imageViewCake.setImage(imageCake3);
        else if (mistakes == 8)
            imageViewCake.setImage(imageCake2);
        else if (mistakes == 9)
            imageViewCake.setImage(imageCake1);
        else if (mistakes == 10)
            imageViewCake.setImage(imageCake0);
    }

    // End of Cake Animation


    // Letter buttons
    @FXML
    public void buttonQ() {
        checkGuess('Q', theWord);
//        userInput.appendText("Q");
    }

    @FXML
    public void buttonW() {
        checkGuess('W', theWord);
//        userInput.appendText("W");
    }

    @FXML
    public void buttonE() {
        checkGuess('E', theWord);
//        userInput.appendText("E");
    }

    @FXML
    public void buttonR() {
        checkGuess('R', theWord);
//        userInput.appendText("R");
    }

    @FXML
    public void buttonT() {
        checkGuess('T', theWord);
//        userInput.appendText("T");
    }

    @FXML
    public void buttonY() {
        checkGuess('Y', theWord);
//        userInput.appendText("Y");
    }

    @FXML
    public void buttonU() {
        checkGuess('U', theWord);
//        userInput.appendText("U");
    }

    @FXML
    public void buttonI() {
        checkGuess('I', theWord);
//        userInput.appendText("I");
    }

    @FXML
    public void buttonO() {
        checkGuess('O', theWord);
//        userInput.appendText("O");
    }

    @FXML
    public void buttonP() {
        checkGuess('P', theWord);
//        userInput.appendText("P");
    }

    @FXML
    public void buttonÅ() {
        checkGuess('Å', theWord);
//        userInput.appendText("Å");
    }

    @FXML
    public void buttonA() {
        checkGuess('A', theWord);
//        userInput.appendText("A");
    }

    @FXML
    public void buttonS() {
        checkGuess('S', theWord);
//        userInput.appendText("S");
    }

    @FXML
    public void buttonD() {
        checkGuess('D', theWord);
//        userInput.appendText("D");
    }

    @FXML
    public void buttonF() {
        checkGuess('F', theWord);
//        userInput.appendText("F");
    }

    @FXML
    public void buttonG() {
        checkGuess('G', theWord);
//        userInput.appendText("G");
    }

    @FXML
    public void buttonH() {
        checkGuess('H', theWord);
//        userInput.appendText("H");
    }

    @FXML
    public void buttonJ() {
        checkGuess('J', theWord);
//        userInput.appendText("J");
    }

    @FXML
    public void buttonK() {
        checkGuess('K', theWord);
//        userInput.appendText("K");
    }

    @FXML
    public void buttonL() {
        checkGuess('L', theWord);
//        userInput.appendText("L");
    }

    @FXML
    public void buttonÖ() {
        checkGuess('Ö', theWord);
//        userInput.appendText("Ö");
    }

    @FXML
    public void buttonÄ() {
        checkGuess('Ä', theWord);
//        userInput.appendText("Ä");
    }

    @FXML
    public void buttonZ() {
        checkGuess('Z', theWord);
//        userInput.appendText("Z");
    }

    @FXML
    public void buttonX() {
        checkGuess('X', theWord);
//        userInput.appendText("X");
    }

    @FXML
    public void buttonC() {
        checkGuess('C', theWord);
//        userInput.appendText("C");
    }

    @FXML
    public void buttonV() {
        checkGuess('V', theWord);
//        userInput.appendText("V");
    }

    @FXML
    public void buttonB() {
        checkGuess('B', theWord);
//        userInput.appendText("B");
    }

    @FXML
    public void buttonN() {
        checkGuess('N', theWord);
//        userInput.appendText("N");
    }

    @FXML
    public void buttonM() {
        checkGuess('M', theWord);
//        userInput.appendText("M");
    }

    // end of Letter buttons

    // Images

    Image imageCake10 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue10 cat.png"));

    Image imageCake9 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue9 cat.png"));

    Image imageCake8 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue8 cat.png"));

    Image imageCake7 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue7 cat.png"));

    Image imageCake6 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue6 cat.png"));

    Image imageCake5 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue5 cat.png"));

    Image imageCake4 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue4 cat.png"));

    Image imageCake3 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue3 cat.png"));

    Image imageCake2 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue2 cat.png"));

    Image imageCake1 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue1 cat.png"));

    Image imageCake0 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue0 cat.png"));
    // end of Images
}

