package com.example.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    Model model = new Model();

    @Test
    @DisplayName("Given add when values 1 and 2 then returns 3")
    void givenAddWhenValues1And2ThenReturns3() {
        //Arrange
        int value1 = 1;
        int value2 = 2;

        //Act
        int result = Model.add(value1, value2);

        //Assert
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("After calling setValue with 2 getValue should return 2")
    void afterCallingSetValueWith2GetValueShouldReturn2() {
        model.setValue(2);

        assertThat(model.getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("checkText is true for empty String")
    void checkTextIsTrueForEmptyString() {
        var result = model.checkText("");

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("checkText is False for non empty String")
    void checkTextIsFalseForNonEmptyString() {
        var result = model.checkText("Hej");

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("some values should always return zero")
    void someValuesShouldAlwaysReturnZero() {
        assertThat(Model.intervall(1)).isZero();
        assertThat(Model.intervall(9)).isZero();
    }

    @Test
    @DisplayName("values outside intervall should return value")
    void valuesOutsideIntervallShouldReturnValue() {
        assertThat(Model.intervall(0)).isZero();
        assertThat(Model.intervall(10)).isEqualTo(10);
    }


}
