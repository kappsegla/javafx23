package com.example.snake;


import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SnakeController {

    public Canvas canvas;

    private Model model = new Model();


    public Model getModel() {
        return model;
    }

    public void initialize() {

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
