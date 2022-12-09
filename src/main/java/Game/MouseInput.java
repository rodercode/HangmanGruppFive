package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MouseInput {
    @FXML
    private TextField textField;

    public void buttonQ() {
        textField.appendText("Q");
    }
    public void buttonW() {
        textField.appendText("W");
    }
    public void buttonE() {
        textField.appendText("E");
    }
    public void buttonR() {
        textField.appendText("R");
    }

    public void getUserInput(ActionEvent actionEvent) {

    }
}

