package com.example.tictactoe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Model {
    private StringProperty message = new SimpleStringProperty();

    private ObservableList<String> names = FXCollections.observableList(new ArrayList<>());

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    public ObservableList<String> getNames() {
        return names;
    }

    public Model addName(String name) {
        names.add(name);
        return this;
    }

    void addNewPerson() {
        String name = getMessage();
        if( name.isEmpty())
            return;
        if( names.contains(name))
            return;
        addName(name);
    }
}
