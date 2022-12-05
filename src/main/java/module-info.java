module com.example.hangmangruppfive {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hangmangruppfive to javafx.fxml;
    exports com.example.hangmangruppfive;
}