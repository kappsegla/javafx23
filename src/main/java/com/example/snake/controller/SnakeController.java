package com.example.snake.controller;


import com.example.snake.utils.GameLoop;
import com.example.snake.model.SnakeBoard;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

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

    private void render(double elapsedTime) {
        var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //ToDo: Render snake
    }


    public void canvasClicked(MouseEvent mouseEvent) {
        var xCoord = mouseEvent.getX();
        var yCoord = mouseEvent.getY();

        var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.LAWNGREEN);
        gc.fillRect(xCoord, yCoord, 15, 15);
    }
}
