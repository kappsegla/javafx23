module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.crud to javafx.fxml;
    exports com.example.crud;
}
