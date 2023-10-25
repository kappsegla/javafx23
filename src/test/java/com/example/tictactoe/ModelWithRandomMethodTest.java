package com.example.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelWithRandomMethodTest {

    @Test
    @DisplayName("random character between A and F")
    void randomCharacterBetweenAAndF() {
        var model = new ModelWithRandomMethod();

        var result = model.randomCharacter();

        assertThat(result).isBetween("A","F");
    }

    @Test
    @DisplayName("random character returns A for random value 0")
    void randomCharacterReturnsAForRandomValue0() {
        var model = new ModelWithRandomMethod(new FixedRandom(0));

        var result = model.randomCharacter2();
        assertThat(result).isEqualTo("A");
    }

    @Test
    @DisplayName("random character returns B for random value 1")
    void randomCharacterReturnsBForRandomValue1() {
        var model = new ModelWithRandomMethod(new FixedRandom(1));

        var result = model.randomCharacter2();
        assertThat(result).isEqualTo("B");
    }

    @Test
    @DisplayName("random character returns B for random value 1 using mock")
    void randomCharacterReturnsBForRandomValue1WithMock() {
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt(6)).thenReturn(1);

        var model = new ModelWithRandomMethod(random);

        var result = model.randomCharacter2();
        assertThat(result).isEqualTo("B");
    }



}
