package com.example.tictactoe;

import javafx.beans.property.*;
import javafx.scene.image.Image;

public class Model {

    public Image image1;
    public Image image2;

    private ObjectProperty<Image> first;
    private ObjectProperty<Image> second;
    private ObjectProperty<Image> third;

    private StringProperty score = new SimpleStringProperty("0 poäng");
    private int yourScore;

    public Model(){
        image1 = new Image(getClass().getResource("images/first.png").toExternalForm());
        image2 = new Image(getClass().getResource("images/second.png").toExternalForm());
        first = new SimpleObjectProperty<>(image1);
        second = new SimpleObjectProperty<>(image1);
        third = new SimpleObjectProperty<>(image1);
    }

    public Image getFirst() {
        return first.get();
    }

    public ObjectProperty<Image> firstProperty() {
        return first;
    }

    public void setFirst(Image first) {
        this.first.set(first);
    }

    public Image getSecond() {
        return second.get();
    }

    public ObjectProperty<Image> secondProperty() {
        return second;
    }

    public void setSecond(Image second) {
        this.second.set(second);
    }

    public Image getThird() {
        return third.get();
    }

    public ObjectProperty<Image> thirdProperty() {
        return third;
    }

    public void setThird(Image third) {
        this.third.set(third);
    }

    public void changeImage() {
        setThird(image2);

    }

    public String getScore() {
        return score.get();
    }

    public StringProperty scoreProperty() {
        return score;
    }

    public void setScore(String score) {
        this.score.set(score);
    }
}
