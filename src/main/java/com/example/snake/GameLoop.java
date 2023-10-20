package com.example.snake;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    @Override
    public void handle(long now) {
        System.out.println(now);
    }
}
