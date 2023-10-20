package com.example.snake.controller;


import com.example.snake.utils.GameLoop;
import com.example.snake.model.SnakeBoard;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.DoubleConsumer;

public class SnakeController {

    public Canvas canvas;

    GameLoop gameLoop;

    private SnakeBoard model = new SnakeBoard();

    public SnakeBoard getModel() {
        return model;
    }

    public void initialize() {
        DoubleConsumer doubleConsumer = model::update;
        doubleConsumer = doubleConsumer.andThen(this::render);

        gameLoop = new GameLoop(doubleConsumer);
        gameLoop.start();
    }

    public void init(Stage stage) {
        stage.getScene().setOnKeyPressed(this::keyPressed);
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP -> model.setUp();
            case DOWN -> model.setDown();
            case LEFT -> model.setLeft();
            case RIGHT -> model.setRight();
        }
    }

    private void render(double elapsedTime) {
        var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.LAWNGREEN);
//
        model.snake.forEach(point -> gc.fillRect(point.xpos() * 15, point.ypos() * 15, 15, 15));

        gc.setFill(Color.BLACK);
        gc.strokeText(model.getGameStatus().toString(), 20, 20);
        gc.setFill(Color.RED);
        gc.fillRect(model.apple.xpos() * 15, model.apple.ypos() * 15, 15, 15);
    }


    public void canvasClicked(MouseEvent mouseEvent) {

    }
}
