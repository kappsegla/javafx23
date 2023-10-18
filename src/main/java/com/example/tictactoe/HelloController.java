package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class HelloController {

    public Button button1;

    public Label welcomeText;
    public Label anotherLabel;
    public TextField textField;

    private Model model = new Model();
    //AudioClip buzzer = new AudioClip(getClass().getResource("sounds/punch.mp3").toExternalForm());

    public Model getModel(){
        return model;
    }

    public void initialize() {
        model.addName("Kalle");
        model.addName("Olle");
        welcomeText.textProperty().bind(model.messageProperty());
        textField.textProperty().bindBidirectional(model.messageProperty());
    }

    @FXML
    protected void onHelloButtonAction() {
        model.addNewPerson();
    }

    public void onLabelClicked(MouseEvent mouseEvent) {

    }
}
