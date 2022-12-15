package Game;

import javafx.event.ActionEvent;
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
import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.util.List;
import java.util.ResourceBundle;

public class GameViewControl implements Initializable {

    // Variables
    private Database database;
    private int mistakes;
    private char[] encryptedWord;
    private String theWord;

    private boolean isLetterCorrect;
    private List<String> listOfBlueCake;
    private List<String> listOfPinkCake;
    private Image imageCakeBlue;
    private Image imageCakePink;

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
    private ImageView imageViewCakeOne;
    @FXML
    private ImageView imageViewCakeTwo;
    @FXML
    private Label scorePlate;

    @FXML
    private Button enter;

    public GameViewControl() throws FileNotFoundException {
        database = Database.getInstance();
        mistakes = 0;
        isLetterCorrect = false;
        listOfBlueCake = new ArrayList<>();
        listOfPinkCake = new ArrayList<>();
        imageCakeBlue = new Image(new FileInputStream(listOfBlueCake.get(10)));
        imageCakePink = new Image(new FileInputStream(listOfPinkCake.get(10)));

        for (int i = 0; i < 11; i++) {
            listOfBlueCake.add("src/main/resources/cakeBlue/cakeBlue" + i + " cat.png");
            listOfPinkCake.add("src/main/resources/cakePink/cakePink" + i + " cat.png");
        }
    }

    // Start method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database.createPlayer(2);
        theWord = database.getListOfWords().get(database.getEnemyPlayer());
        encryptedWord = new char[theWord.length()];
        wordGuess.setAlignment(Pos.CENTER);
        wordGuess.setText(displayHiddenWord());
        imageViewCakeOne.setImage(imageCakeBlue);
        imageViewCakeTwo.setImage(imageCakePink);
        playerPlate.setText("Player " + database.getCurrentPlayer() + "'s Turn");
    }

    public void switchPlayer() {
        database.switchPlayer();
        mistakes = 0;
        playerPlate.setText("Player " + database.getCurrentPlayer() + "'s Turn");
        scorePlate.setText("Score: " + database.getPlayerScores().get(2));
        switchTheWord();
        if (database.getCurrentPlayer() < 5) {
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
                isLetterCorrect = true;
            }
        }
        checkAnswer();
        String newHiddenWord = String.valueOf(encryptedWord);
        wordGuess.setText(newHiddenWord.replace("", " ").trim());
    }

    public void checkAnswer() {
        if (isLetterCorrect) {
            correctAnswer();
        } else {
            makeAMistake();
        }
    }

    public void makeAMistake() {
        if (mistakes < 10 && !isWordCorrect()) {
            mistakes++;
//            displayCakeImage();
        } else if (mistakes == 10) {
            enter.setText("Next");
            database.setItGameOver(true);
        }

        mistakePlate.setText("Mistake: " + mistakes + "/10");
    }

    public void correctAnswer() {
        isLetterCorrect = false;
        getPoint();
    }

    public boolean isWordCorrect() {
        String s = String.valueOf(encryptedWord);

        if (theWord.equals(s)) {
            return true;

        } else {
            return false;
        }
    }

    public void getPoint() {
        String s = String.valueOf(encryptedWord);
        if (isWordCorrect()) {
            enter.setText("Next");
            database.addScore(database.getCurrentPlayer());
            scorePlate.setText("Score: " + database.getPlayerScores().get(database.getCurrentPlayer()));
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
            database.addScore(database.getCurrentPlayer());
            scorePlate.setText("Score: " + database.getPlayerScores().get(database.getCurrentPlayer()));
            switchPlayer();
            System.out.println("You get a point");
        } else if (isWordCorrect()) {
            switchGameScene();
            switchPlayer();
        } else if (!isWordCorrect()) {
            switchGameScene();
            switchPlayer();
        }
        userInput.setText("");
        System.out.println("Fel");
    }

    // Cake animation
    @FXML
    public void displayCakeImage(ImageView imageViewCake) {
//        if (mistakes == 1)
//            imageViewCake.setImage(imageCakeBlue9);
//        else if (mistakes == 2)
//            imageViewCake.setImage(imageCakeBlue8);
//        else if (mistakes == 3)
//            imageViewCake.setImage(imageCakeBlue7);
//        else if (mistakes == 4)
//            imageViewCake.setImage(imageCakeBlue6);
//        else if (mistakes == 5)
//            imageViewCake.setImage(imageCakeBlue5);
//        else if (mistakes == 6)
//            imageViewCake.setImage(imageCakeBlue4);
//        else if (mistakes == 7)
//            imageViewCake.setImage(imageCakeBlue3);
//        else if (mistakes == 8)
//            imageViewCake.setImage(imageCakeBlue2);
//        else if (mistakes == 9)
//            imageViewCake.setImage(imageCakeBlue1);
//        else if (mistakes == 10)
//            imageViewCake.setImage(imageCakeBlue0);
    }
    // End of Cake Animation

    // Letter buttons
    @FXML
    public void handleButtonPress(ActionEvent event) {
        Button button = (Button) event.getSource();
        checkGuess(button.getText().charAt(0), theWord);
    }

    public void addBlueCake() {


    }


//    Image imageCakeBlue = new Image(new FileInputStream(listOfBlueCake.get(0)));


//    Image imageCakeBlue10 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue10 cat.png"));
//
//    Image imageCakeBlue9 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue9 cat.png"));
//
//    Image imageCakeBlue8 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue8 cat.png"));
//
//    Image imageCakeBlue7 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue7 cat.png"));
//
//    Image imageCakeBlue6 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue6 cat.png"));
//
//    Image imageCakeBlue5 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue5 cat.png"));
//
//    Image imageCakeBlue4 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue4 cat.png"));
//
//    Image imageCakeBlue3 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue3 cat.png"));
//
//    Image imageCakeBlue2 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue2 cat.png"));
//
//    Image imageCakeBlue1 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue1 cat.png"));
//
//    Image imageCakeBlue0 = new Image(new FileInputStream("src/main/resources/cakeBlue/cakeBlue0 cat.png"));
//
//    Image imageCakePink10 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink10 cat.png"));
//
//    Image imageCakePink9 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink9 cat.png"));
//
//    Image imageCakePink8 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink8 cat.png"));
//
//    Image imageCakePink7 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink7 cat.png"));
//
//    Image imageCakePink6 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink6 cat.png"));
//
//    Image imageCakePink5 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink5 cat.png"));
//
//    Image imageCakePink4 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink4 cat.png"));
//
//    Image imageCakePink3 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink3 cat.png"));
//
//    Image imageCakePink2 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink2 cat.png"));
//
//    Image imageCakePink1 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink1 cat.png"));
//
//    Image imageCakePink0 = new Image(new FileInputStream("src/main/resources/cakePink/cakePink0 cat.png"));
}

