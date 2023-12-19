package com.example.tictactoe;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Model {
    private StringProperty cell1 = new SimpleStringProperty("X");


    public Model() {

    }

    public String getCell1() {
        return cell1.get();
    }

    public StringProperty cell1Property() {
        return cell1;
    }

    public void setCell1(String cell1) {
        this.cell1.set(cell1);
    }
}
