package Game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MouseInput {
    @FXML
    private Label testText;

    public void buttonQ() {
        testText.setText("Q");
    }
}
