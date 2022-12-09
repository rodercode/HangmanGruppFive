package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MouseInput {
    @FXML
    private TextField guess;

    public void buttonQ() {
        guess.setText("Q");
    }

    public void getUserInput(ActionEvent actionEvent) {

    }
}

