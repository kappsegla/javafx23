package com.example.tictactoe;

import java.util.Arrays;

public class StringCalculator {
    public static int add(String text) {
        if (text.isEmpty()) return 0;
        return Arrays.stream(text.split("[,\\n]"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
