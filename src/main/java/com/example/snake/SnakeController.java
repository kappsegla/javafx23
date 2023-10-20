package com.example.snake;


import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

public class SnakeController {

    public Canvas canvas;

    GameLoop gameLoop;

    private Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void initialize() {
        DoubleConsumer doubleConsumer = model::update;
        doubleConsumer = doubleConsumer.andThen(this::render);

        gameLoop = new GameLoop(doubleConsumer);
        gameLoop.start();
    }

    private void render(double elapsedTime) {
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
