package com.example.tictactoe;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Model {
    private StringProperty name = new SimpleStringProperty();

    private ObservableList<String> names = FXCollections.observableList(new ArrayList<>());

    private BooleanProperty saveDisabled = new SimpleBooleanProperty(true);

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
        setSaveDisabled(false);
        setName("");
    }

    public void saveToFile(Path path) {
        setSaveDisabled(true);
        String joinedNames = names.stream().collect(Collectors.joining("\n"));
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                Files.writeString(path, joinedNames);
                System.out.println("File saved...");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                Platform.runLater(() -> setSaveDisabled(false));
            }
        });

        thread.start();
    }

    public boolean isSaveDisabled() {
        return saveDisabled.get();
    }

    public BooleanProperty saveDisabledProperty() {
        return saveDisabled;
    }

    public void setSaveDisabled(boolean saveEnabled) {
        this.saveDisabled.set(saveEnabled);
    }
}
