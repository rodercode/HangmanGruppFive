package Game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class GameViewControl implements Initializable {

    // Variables
    private Database database;
    private int remainingGuesses;
    private char[] encryptedWord;
    private int mistakes;
    private int currentPlayer;
    private String theWord;
    private int enemyPlayer;

    private boolean isAnswerCorrect;

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

    public GameViewControl() throws FileNotFoundException {
        database = Database.getInstance();
        enemyPlayer = 2;
        remainingGuesses = 10;
        theWord = database.getListOfWords().get(enemyPlayer);
        encryptedWord = new char[theWord.length()];
        mistakes = 0;
        isAnswerCorrect = false;
        currentPlayer = 1;
    }
    // Start method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        switchPlayer();
//        database.createPlayer(2);
        database.createPlayer(2);
        System.out.println(database.getPlayerScores().get(2));
        wordGuess.setAlignment(Pos.CENTER);
        wordGuess.setText(displayHiddenWord());
        imageViewCake.setImage(imageCake10);
    }

    public static void waitAnimation(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    public void switchPlayer(){
        currentPlayer++;
        mistakes = 0;
        playerPlate.setText("Player "+currentPlayer+"'s Turn");
        scorePlate.setText("Score: " + database.getPlayerScores().get(2));
        switchWord();
    }
    // switch from player 2 to Player 1's word
    public void switchWord(){
        theWord = database.getListOfWords().get(1);
        encryptedWord = new char[theWord.length()];
        wordGuess.setText(displayHiddenWord());
    }
    public char[] generateHiddenWord(){
        Arrays.fill(encryptedWord, '_');
        return encryptedWord;
    }

    public String displayHiddenWord() {
        String newWord = String.valueOf(generateHiddenWord());
        return newWord.replace(""," ").trim();
    }
    public void checkIfLetterExist(char letter,String guessWord) {
        for (int i = 0; i < encryptedWord.length ; i++) {
            if (guessWord.charAt(i) == letter){
                encryptedWord[i] = letter;
                isAnswerCorrect = true;
            }
        }
        checkAnswer();
        String newHiddenWord = String.valueOf(encryptedWord);
        wordGuess.setText(newHiddenWord.replace(""," ").trim());
    }

    public void checkAnswer(){
        if (isAnswerCorrect){
            correctAnswer();
        }else {
            makeAMistake();
        }
    }
    public void makeAMistake(){
        mistakes++;
        if (mistakes == 12){
            System.out.println("You lost the game");
        }
        mistakePlate.setText("Mistake: " + mistakes +"/12");
    }
    public void correctAnswer(){
        isAnswerCorrect = false;
        getPoint();
    }
    int point = 0;
    public void getPoint(){
        String s = String.valueOf(encryptedWord);
        if (s.equals(theWord)){
            userInput.setText("");
            database.addScore(currentPlayer);
            scorePlate.setText("Score: " + database.getPlayerScores().get(currentPlayer));

            switchPlayer();
            System.out.println("You get a point");
        }
    }
    @FXML
    public void pressEnter() {
        if (userInput.getText().toUpperCase().equals(theWord)) {
            System.out.println("Funkade :D");
        } else {
            System.out.println("Fel");
        }
        userInput.setText("");
    }

    // Cake animation
    @FXML
    public void displayCakeImage() {
            if (remainingGuesses == 10)
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
        checkIfLetterExist('Q',theWord);
        userInput.appendText("Q");
    }

    @FXML
    public void buttonW() {
        checkIfLetterExist('R',theWord);
        userInput.appendText("W");
    }

    @FXML
    public void buttonE() {
        checkIfLetterExist('E',theWord);
        userInput.appendText("E");
    }

    @FXML
    public void buttonR() {
        checkIfLetterExist('R',theWord);
        userInput.appendText("R");
    }

    @FXML
    public void buttonT() {
        checkIfLetterExist('T',theWord);
        userInput.appendText("T");
    }

    @FXML
    public void buttonY() {
        checkIfLetterExist('Y',theWord);
        userInput.appendText("Y");
    }

    @FXML
    public void buttonU() {
        checkIfLetterExist('U',theWord);
        userInput.appendText("U");
    }

    @FXML
    public void buttonI() {
        checkIfLetterExist('I',theWord);
        userInput.appendText("I");
    }

    @FXML
    public void buttonO() {
        checkIfLetterExist('O',theWord);
        userInput.appendText("O");
    }

    @FXML
    public void buttonP() {
        checkIfLetterExist('P',theWord);
        userInput.appendText("P");
    }

    @FXML
    public void buttonÅ() {
        checkIfLetterExist('Å',theWord);
        userInput.appendText("Å");
    }

    @FXML
    public void buttonA() {
        checkIfLetterExist('A',theWord);
        userInput.appendText("A");
    }

    @FXML
    public void buttonS() {
        checkIfLetterExist('S',theWord);
        userInput.appendText("S");
    }

    @FXML
    public void buttonD() {
        checkIfLetterExist('D',theWord);
        userInput.appendText("D");
    }

    @FXML
    public void buttonF() {
        checkIfLetterExist('F',theWord);
        userInput.appendText("F");
    }

    @FXML
    public void buttonG() {
        checkIfLetterExist('G',theWord);
        userInput.appendText("G");
    }

    @FXML
    public void buttonH() {
        checkIfLetterExist('H',theWord);
        userInput.appendText("H");
    }

    @FXML
    public void buttonJ() {
        checkIfLetterExist('J',theWord);
        userInput.appendText("J");
    }

    @FXML
    public void buttonK() {
        checkIfLetterExist('K',theWord);
        userInput.appendText("K");
    }

    @FXML
    public void buttonL() {
        checkIfLetterExist('L',theWord);
        userInput.appendText("L");
    }

    @FXML
    public void buttonÖ() {
        checkIfLetterExist('Ö',theWord);
        userInput.appendText("Ö");
    }

    @FXML
    public void buttonÄ() {
        checkIfLetterExist('Ä',theWord);
        userInput.appendText("Ä");
    }

    @FXML
    public void buttonZ() {
        checkIfLetterExist('Z',theWord);
        userInput.appendText("Z");
    }

    @FXML
    public void buttonX() {
        checkIfLetterExist('X',theWord);
        userInput.appendText("X");
    }

    @FXML
    public void buttonC() {
        checkIfLetterExist('C',theWord);
        userInput.appendText("C");
    }

    @FXML
    public void buttonV() {
        checkIfLetterExist('V',theWord);
        userInput.appendText("V");
    }

    @FXML
    public void buttonB() {
        checkIfLetterExist('B',theWord);
        userInput.appendText("B");
    }

    @FXML
    public void buttonN() {
        checkIfLetterExist('N',theWord);
        userInput.appendText("N");
    }

    @FXML
    public void buttonM() {
        checkIfLetterExist('M',theWord);
        userInput.appendText("M");
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

