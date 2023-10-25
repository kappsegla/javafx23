package com.example.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {


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


}
