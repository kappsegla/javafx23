package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.util.stream.Stream;


public class HelloController {


    private Model model = new Model();
    //AudioClip buzzer = new AudioClip(getClass().getResource("sounds/punch.mp3").toExternalForm());

    public Model getModel() {
        return model;
    }

    public void initialize() {

    }


    public void image1Clicked(MouseEvent mouseEvent) {

    }

    public void image2Clicked(MouseEvent mouseEvent) {

    }

    public void image3Clicked(MouseEvent mouseEvent) {

    }
}
