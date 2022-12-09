package Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MouseInput {
    @FXML
    private Label testText;
    @FXML
    private TextField guess;
    @FXML
    private Text theWordField;

    public void buttonQ() {
        guess.setText("Q");
    }

    public void getUserInput(ActionEvent actionEvent) {
    }
}

