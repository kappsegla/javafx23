package com.example.tictactoe;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;


public class HelloController {


    private Model model = new Model();
    AudioClip buzzer = new AudioClip(getClass().getResource("sounds/punch.mp3").toExternalForm());

    public Model getModel() {
        return model;
    }

    public void initialize() {

    }


    public void image1Clicked(MouseEvent mouseEvent) {
        buzzer.play();
    }

    public void image2Clicked(MouseEvent mouseEvent) {
        buzzer.play();
    }

    public void image3Clicked(MouseEvent mouseEvent) {
        buzzer.play();
    }
}
