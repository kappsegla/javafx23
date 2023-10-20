package com.example.snake.model;

import static com.example.snake.model.SnakeBoard.Direction.*;

public class SnakeBoard {

    public Point head;
    private Direction currentDirection = UP;
    private double accumulatedTime = 0.0;

    public SnakeBoard() {
        head = new Point(20, 20);
    }

    public void update(double elapsedTime) {

        accumulatedTime += elapsedTime;

        if (accumulatedTime < 0.30)
            return;
        accumulatedTime = 0.0;

        if (currentDirection == UP)
            head = new Point(head.xpos, head.ypos - 1);
        if (currentDirection == DOWN)
            head = new Point(head.xpos, head.ypos + 1);
        if (currentDirection == LEFT)
            head = new Point(head.xpos - 1, head.ypos);
        if (currentDirection == RIGHT)
            head = new Point(head.xpos + 1, head.ypos);
    }

    public void setUp() {
        if (currentDirection != DOWN)
            currentDirection = UP;
    }

    public void setDown() {
        if (currentDirection != UP)
            currentDirection = DOWN;
    }

    public void setLeft() {
        if (currentDirection != RIGHT)
            currentDirection = LEFT;
    }

    public void setRight() {
        if (currentDirection != LEFT)
            currentDirection = RIGHT;
    }

    public record Point(int xpos, int ypos) {
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
