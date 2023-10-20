package com.example.snake.utils;

import javafx.animation.AnimationTimer;

import java.util.function.DoubleConsumer;

public class GameLoop extends AnimationTimer {

    long lastFrameTimeNanos = 0;
    final DoubleConsumer tick;

    public GameLoop(DoubleConsumer tick) {
        this.tick = tick;
    }

    @Override
    public void handle(long now) {
        if (lastFrameTimeNanos == 0)
            lastFrameTimeNanos = now;

        float elapsedTime = (now - lastFrameTimeNanos) / 1e9f;
        lastFrameTimeNanos = now;

        tick.accept(elapsedTime);
    }
}
