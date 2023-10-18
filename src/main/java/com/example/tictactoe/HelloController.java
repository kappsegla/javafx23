package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.util.stream.Stream;


public class HelloController {

    public Button saveButton;

    public TextField textField;

    private Model model = new Model();
    //AudioClip buzzer = new AudioClip(getClass().getResource("sounds/punch.mp3").toExternalForm());

    public Model getModel() {
        return model;
    }

    public void initialize() {
        textField.textProperty().bindBidirectional(model.nameProperty());
    }

    public void onAddButtonAction() {
        model.addNewPerson();
    }

    public void onSaveButtonAction(ActionEvent event ) {
        Window window =
                ((Node) event.getSource()).getScene().getWindow();
        //ToDo: Reuse same fileChooser instance
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save As");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text File", "*.txt"));
        File selectedFile = fileChooser.showSaveDialog(window);
        if (selectedFile != null) {
            model.saveToFile(selectedFile.toPath(), saveButton);
        }
    }
}
