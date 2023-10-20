package com.example.snake;

import com.example.snake.controller.SnakeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("snake-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Snake");
        stage.setScene(scene);
        fxmlLoader.<SnakeController>getController().init(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
