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

    @Test
    @DisplayName("string containing one returns one")
    void stringContainingOneReturnsOne() {
        int result = StringCalculator.add("1");

        assertThat(result).isOne();
    }

    @Test
    @DisplayName("string containing two returns two")
    void stringContainingTwoReturnsTwo() {
        int result = StringCalculator.add("2");

        assertThat(result).isEqualTo(2);
    }




}
