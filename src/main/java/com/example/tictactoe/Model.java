package com.example.tictactoe;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Random;

public class Model {

    public Image image1;
    public Image image2;

    private ObjectProperty<Image> first;
    private ObjectProperty<Image> second;
    private ObjectProperty<Image> third;

    private StringProperty score = new SimpleStringProperty("0 poäng");
    private int yourScore;
    private Thread thread;

    public Model() {
        image1 = new Image(getClass().getResource("images/first.png").toExternalForm());
        image2 = new Image(getClass().getResource("images/second.png").toExternalForm());
        first = new SimpleObjectProperty<>(image1);
        second = new SimpleObjectProperty<>(image1);
        third = new SimpleObjectProperty<>(image1);

        List<ObjectProperty<Image>> images = List.of(first,second,third);

        Thread.ofVirtual().start(() -> {
            Random random = new Random();
            while (true) {
                int sleepTime = random.nextInt(500, 3000);
                int next = random.nextInt(0,3);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Platform.runLater(()-> images.get(next).set(image2));
            }
        });

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

    public void smack(int i) {
        if (i == 1) {
            if (first.get().equals(image2)) {
                yourScore++;
                setFirst(image1);
            }
        }
        if (i == 2) {
            if (second.get().equals(image2)) {
                yourScore++;
                setSecond(image1);
            }
        }
        if (i == 3) {
            if (third.get().equals(image2)) {
                yourScore++;
                setThird(image1);
            }
        }
        setScore(yourScore + " poäng");
    }
}
