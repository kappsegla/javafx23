package com.example.tictactoe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Model {
    private StringProperty name = new SimpleStringProperty();

    private ObservableList<String> names = FXCollections.observableList(new ArrayList<>());

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ObservableList<String> getNames() {
        return names;
    }

    public Model addName(String name) {
        names.add(name);
        return this;
    }

    void addNewPerson() {
        String name = getName();
        if (name.isEmpty())
            return;
        if (names.contains(name))
            return;
        addName(name);
    }

    public void saveToFile(Path path) {
        String joinedNames = names.stream().collect(Collectors.joining("\n"));

        try {
            Files.writeString(path, joinedNames);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
