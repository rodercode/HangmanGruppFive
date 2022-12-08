package Game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Control {
    @FXML
    private Label testText;

    @FXML
    //protected void onHelloButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");
    //}

    public void buttonQ(){
        testText.setText("Q");
    }
}