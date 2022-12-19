module com.example.hangmangruppfive {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens Game to javafx.fxml;
    exports Game;
}