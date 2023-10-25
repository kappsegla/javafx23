package com.example.tictactoe;

public class StringCalculator {
    public static int add(String text) {
        if (text.isEmpty()) return 0;
        return Integer.parseInt(text);
    }
}
