package com.example.snake.model;

import static com.example.snake.model.SnakeBoard.Direction.*;
import static com.example.snake.model.SnakeBoard.GameStatus.*;

public class SnakeBoard {

    public Point head;
    private Direction currentDirection = UP;
    private double accumulatedTime = 0.0;
    private GameStatus gameStatus = RUNNING;

    public SnakeBoard() {
        head = new Point(20, 20);
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

        if (currentDirection == UP)
            head = new Point(head.xpos, head.ypos - 1);
        if (currentDirection == DOWN)
            head = new Point(head.xpos, head.ypos + 1);
        if (currentDirection == LEFT)
            head = new Point(head.xpos - 1, head.ypos);
        if (currentDirection == RIGHT)
            head = new Point(head.xpos + 1, head.ypos);

        //Todo: Check for collisions with walls, keep track of game status
        if (head.xpos < 0 || head.xpos > 39)
            gameStatus = GAME_OVER;
        if (head.ypos < 0 || head.ypos > 39)
            gameStatus = GAME_OVER;


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
