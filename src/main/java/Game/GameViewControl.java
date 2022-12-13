package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameViewControl implements Initializable {

private int remainingGuesses;
    public GameViewControl() throws FileNotFoundException {
        remainingGuesses = 12;
    }

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
    @FXML
    ImageView imageViewCake12;
    Image imageCake12 = new Image(new FileInputStream("src/main/resources/IMG/Cake12.png"));
    @FXML
    Button buttonToSwitchImages;
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


    @FXML
    public void displayCakeImage() {
        if(remainingGuesses == 12)
        imageViewCake12.setImage(imageCake12);
        else if(remainingGuesses == 11)
            imageViewCake12.setImage(imageCake11);
        else if(remainingGuesses == 10)
            imageViewCake12.setImage(imageCake10);
        else if(remainingGuesses == 9)
            imageViewCake12.setImage(imageCake9);
        else if(remainingGuesses == 8)
            imageViewCake12.setImage(imageCake8);
        else if(remainingGuesses == 7)
            imageViewCake12.setImage(imageCake7);
        else if(remainingGuesses == 6)
            imageViewCake12.setImage(imageCake6);
        else if(remainingGuesses == 5)
            imageViewCake12.setImage(imageCake5);
        else if(remainingGuesses == 4)
            imageViewCake12.setImage(imageCake4);
        else if(remainingGuesses == 3)
            imageViewCake12.setImage(imageCake3);
        else if(remainingGuesses == 2)
            imageViewCake12.setImage(imageCake2);
        else if(remainingGuesses == 1)
            imageViewCake12.setImage(imageCake1);
        else if(remainingGuesses == 0)
            imageViewCake12.setImage(imageCake0);
        remainingGuesses--;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageViewCake12.setImage(imageCake12);

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
