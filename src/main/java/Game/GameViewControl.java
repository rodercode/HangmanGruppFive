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
import java.util.*;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GameViewControl implements Initializable {
    // Variables
    private Database database;
    private int mistakesOne;
    private int mistakeTwo;
    private char[] encryptedWordOne;
    private char[] encryptedWordTwo;
    private boolean isLetterCorrect;
    private boolean wordCorrect = false;
    private List<String> listOfBlueCake;
    private List<String> listOfPinkCake;
    private Image imageCakeBlue;
    private Image imageCakePink;

    private int currentPlayer;
    private int enemyPlayer;
    private HashMap<Integer, Label> listOfWordGuess;
    private HashMap<Integer, char[]> listOfEncryptedWord;

    // FXML variables
    @FXML
    private Label playerPlate1;
    @FXML
    private Label playerPlate2;
    @FXML
    private TextField userInput;
    @FXML
    private Label wordGuess1;

    @FXML
    private Label wordGuess2;

    @FXML
    private ImageView imageViewCakeOne;
    @FXML
    private ImageView imageViewCakeTwo;
    @FXML
    private Label scorePlate1;
    @FXML
    private Label scorePlate2;
    @FXML
    private Label mistakePlate1;
    @FXML
    private Label mistakePlate2;

    @FXML
    private Button enter;

    public GameViewControl() throws FileNotFoundException {
        database = Database.getInstance();
        mistakesOne = 0;
        mistakeTwo = 0;
        currentPlayer = 1;
        enemyPlayer = 2;
        isLetterCorrect = false;

        // word players create at the start
        listOfWordGuess = new HashMap<>();
        String theWordOne = database.getListOfWords().get(2);
        String theWordTwo = database.getListOfWords().get(1);

        // list of all EncryptedWord
        encryptedWordOne = new char[theWordOne.length()];
        encryptedWordTwo = new char[theWordTwo.length()];

        listOfEncryptedWord = new HashMap<>();
        listOfEncryptedWord.put(1, encryptedWordOne);
        listOfEncryptedWord.put(2, encryptedWordTwo);

        // list of Cake Pictures for the cake animation
        listOfBlueCake = new ArrayList<>();
        listOfPinkCake = new ArrayList<>();
        addImagesToLists();
    }

    // Start method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        highlightPlayer();
        // display encrypted word to Player One
        wordGuess1.setAlignment(Pos.BASELINE_LEFT);
        wordGuess1.setText(displayHiddenWord(encryptedWordOne));

        // display encrypted word to Player Two
        wordGuess2.setAlignment(Pos.BASELINE_CENTER);
        wordGuess2.setText(displayHiddenWord(encryptedWordTwo));

        // put encrypted words in a hashmap
        listOfWordGuess.put(1, wordGuess1);
        listOfWordGuess.put(2, wordGuess2);

        database.getPlayerMistakes().put(1,0);
        database.getPlayerMistakes().put(2,0);

        // set Cake Image Pink and Blue
        importImagePinkCake();
        importImageBlueCake();

        imageViewCakeOne.setImage(imageCakeBlue);
        imageViewCakeTwo.setImage(imageCakePink);

        scorePlate1.setText("Score: "+database.getPlayerScores().get(1));
        scorePlate2.setText("Score: "+database.getPlayerScores().get(2));

    }
    public void importImagePinkCake(){
        try {
            imageCakePink = new Image(new FileInputStream(listOfPinkCake.get(database.getPlayerMistakes().get(1))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void importImageBlueCake(){
        try {
            imageCakeBlue = new Image(new FileInputStream(listOfBlueCake.get(database.getPlayerMistakes().get(2))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // change color of Player One and Player Two labels
    public void highlightPlayer() {
        if (currentPlayer == 1) {
            playerPlate2.setStyle("-fx-text-fill: grey");
            mistakePlate2.setStyle("-fx-text-fill: grey");
            scorePlate2.setStyle("-fx-text-fill: grey");

            playerPlate1.setStyle("-fx-text-fill: #f797c7 ");
            mistakePlate1.setStyle("-fx-text-fill: #f797c7 ");
            scorePlate1.setStyle("-fx-text-fill: #f797c7 ");

        } else if (currentPlayer == 2) {
            playerPlate1.setStyle("-fx-text-fill: grey");
            mistakePlate1.setStyle("-fx-text-fill: grey");
            scorePlate1.setStyle("-fx-text-fill: grey");

            playerPlate2.setStyle("-fx-text-fill: #6db8e4 ");
            mistakePlate2.setStyle("-fx-text-fill: #6db8e4 ");
            scorePlate2.setStyle("-fx-text-fill: #6db8e4 ");
        }
    }

    // add all Cake images to two separate lists
    public void addImagesToLists() {
        for (int i = 0; i < 11; i++) {
            listOfBlueCake.add("src/main/resources/cakeBlue/cakeBlue" + i + " cat.png");
            listOfPinkCake.add("src/main/resources/cakePink/cakePink" + i + " cat.png");
        }
    }

    // Switch from current Player to the opponent
    public void switchPlayer() {
        if (currentPlayer == 2) {
            currentPlayer--;
            enemyPlayer++;
        } else if (currentPlayer == 1) {
            currentPlayer++;
            enemyPlayer--;
        }
    }

    // Generate an encrypted word
    public char[] generateHiddenWord(char[] encryptedWord) {
        Arrays.fill(encryptedWord, '_');
        return encryptedWord;
    }

    // Display an encrypted word
    public String displayHiddenWord(char[] encryptedWord) {
        String newWord = String.valueOf(generateHiddenWord(encryptedWord));
        return newWord.replace("", " ").trim();
    }

    // check if userInput letter match any letters in the opponent's word
    public void checkGuess(char letter, String guessWord, char[] encryptedWord, Label wordGuess) {
        for (int i = 0; i < encryptedWord.length; i++) {
            if (guessWord.charAt(i) == letter) {
                encryptedWord[i] = letter;
                isLetterCorrect = true;
            }
        }

        checkAnswer();
        String s = String.valueOf(encryptedWord);
        wordGuess.setText(s.replace("", " ").trim());
    }

    // check if userInput was correct or incorrect and switch player
    public void checkAnswer() {
        if (isWordCorrect(listOfEncryptedWord.get(currentPlayer))) {
            getPoint();
        } else if (isLetterCorrect) {
            isLetterCorrect = false;
        } else {
            makeAMistake();
        }
        switchPlayer();
    }

    // if Player made a Mistake
    public void makeAMistake() {
        if (database.getPlayerMistakes().get(currentPlayer) < 10){
            if (currentPlayer == 1) {
                database.addMistake(1);
                mistakePlate1.setText("Mistake: " + database.getPlayerMistakes().get(1) + "/10");
                importImagePinkCake();
                imageViewCakeTwo.setImage(imageCakePink);
            } else if (currentPlayer == 2) {
                database.addMistake(2);
                mistakePlate2.setText("Mistake: " + database.getPlayerMistakes().get(2) + "/10");
                importImageBlueCake();
                imageViewCakeOne.setImage(imageCakeBlue);
                if(database.getPlayerMistakes().get(2) == 10){
                    try {
                        switchGameScene();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } //else if (database.getPlayerMistakes().get(2) == 9){
            //System.out.println(":D");
          //  try {
                //switchGameScene();
            //} catch (IOException e) {
              //  throw new RuntimeException(e);
            //}
        }


    public boolean isWordCorrect(char[] encryptedWord) {
        String s = String.valueOf(encryptedWord);
        return database.getListOfWords().get(enemyPlayer).equals(s);
    }

    // if player figure out theWord
    public void getPoint() {
        if (currentPlayer == 1) {
            database.addScore(1);
            scorePlate1.setText("Score: " + database.getPlayerScores().get(1));
        } else if (currentPlayer == 2) {
            database.addScore(2);
            scorePlate2.setText("Score: " + database.getPlayerScores().get(2));
        }
        try {
            switchGameScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchGameScene() throws IOException {
        Parent root = FXMLLoader.load(GameViewControl.class.getResource("ScoreView.fxml"));
        Stage window = (Stage) enter.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void pressEnter() throws IOException {

//        String s = String.valueOf(encryptedWord);
//        if (userInput.getText().toUpperCase().equals(theWord)) {
//            userInput.setText("");
//            database.addScore(database.getCurrentPlayer());
//            scorePlate.setText("Score: " + database.getPlayerScores().get(database.getCurrentPlayer()));
//            switchPlayer();
//            System.out.println("You get a point");
//        } else if (isWordCorrect()) {
//            switchGameScene();
//            switchPlayer();
//        } else if (!isWordCorrect()) {
//            switchGameScene();
//            switchPlayer();
//        }
//        userInput.setText("");
//        System.out.println("Fel");

//        String s = String.valueOf(encryptedWordOne);
//        if (userInput.getText().toUpperCase().equals()) {
//            userInput.setText("");
//            database.addScore(database.getCurrentPlayer());
//            scorePlate1.setText("Score: " + database.getPlayerScores().get(database.getCurrentPlayer()));
//            switchPlayer();
//            System.out.println("You get a point");
//        } else if (isWordCorrect()) {
//            switchGameScene();
//            switchPlayer();
//        } else if (!isWordCorrect()) {
//            switchGameScene();
//            switchPlayer();
//        }
//        userInput.setText("");
//        System.out.println("Fel");

    }

    // Cake animation which change after each mistake
    @FXML
    public void displayCakeImage(ImageView imageViewCake, Image imageCake) {
        imageViewCake.setImage(imageCake);
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
        checkGuess(button.getText().charAt(0), database.getListOfWords().get(enemyPlayer), listOfEncryptedWord.get(currentPlayer), listOfWordGuess.get(currentPlayer));
//        button.setStyle("-fx-background-color: white");
//        button.setStyle("-fx-text-fill: white");
        highlightPlayer();
    }
}

