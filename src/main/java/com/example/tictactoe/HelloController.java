package com.example.tictactoe;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;


public class HelloController {

    private Model model = new Model();

    public Label label1;

    public void initialize()
    {
        label1.textProperty().bind(model.cell1Property());
    }


    public void labelClicked(MouseEvent mouseEvent) {
        model.setCell1("O");
    }
}
