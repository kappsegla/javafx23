package com.example.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("emptyStringReturnsZero")
    void emptyStringReturnsZero() {
        int result = StringCalculator.add("");

        assertThat(result).isZero();
    }
}
