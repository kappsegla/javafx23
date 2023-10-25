package com.example.tictactoe;

import java.util.Random;

public class FixedRandom extends Random {

    private int fixedValue;
    public FixedRandom(int fixedValue){
        super();
        this.fixedValue = fixedValue;
    }
    @Override
    public int nextInt(int bound) {
        return fixedValue;
    }
}
