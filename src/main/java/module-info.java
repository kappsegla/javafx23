module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.snake to javafx.fxml;
    exports com.example.snake;
    exports com.example.snake.model;
    opens com.example.snake.model to javafx.fxml;
    exports com.example.snake.controller;
    opens com.example.snake.controller to javafx.fxml;
    exports com.example.snake.utils;
    opens com.example.snake.utils to javafx.fxml;
}
