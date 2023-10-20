package com.example.snake.model;

import java.util.Random;

import static com.example.snake.model.SnakeBoard.Direction.*;
import static com.example.snake.model.SnakeBoard.GameStatus.*;

public class SnakeBoard {

    public static final int BOARD_SIZE = 40;
    public Point head;
    public Point apple;
    private Direction currentDirection = UP;
    private double accumulatedTime = 0.0;
    private GameStatus gameStatus = RUNNING;
    Random random = new Random();

    public SnakeBoard() {
        head = new Point(20, 20);
        apple = randomApple();
    }

    private Point randomApple() {
        return new Point(random.nextInt(BOARD_SIZE),random.nextInt(BOARD_SIZE));
    }


    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void update(double elapsedTime) {
        if (gameStatus == PAUSED || gameStatus == GAME_OVER)
            return;

        accumulatedTime += elapsedTime;
        if (accumulatedTime < 0.30)
            return;
        accumulatedTime = 0.0;

        Point next = switch (currentDirection) {
            case UP -> new Point(head.xpos, head.ypos - 1);
            case DOWN -> new Point(head.xpos, head.ypos + 1);
            case LEFT -> new Point(head.xpos - 1, head.ypos);
            case RIGHT -> new Point(head.xpos + 1, head.ypos);
        };

        if (next.xpos < 0 || next.xpos > 39)
            gameStatus = GAME_OVER;
        else if (next.ypos < 0 || next.ypos > 39)
            gameStatus = GAME_OVER;
        else
            head = next;



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

    public enum GameStatus {
        PAUSED,
        RUNNING,
        GAME_OVER
    }
}
