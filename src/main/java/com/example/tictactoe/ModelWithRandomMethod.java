package com.example.tictactoe;

import java.util.Random;

public class ModelWithRandomMethod {
    Random random;

    public ModelWithRandomMethod(){
        random = new Random();
    }
    public ModelWithRandomMethod(Random random){
        this.random = random;
    }

    public String randomCharacter(){
        Random random = new Random();
        int randomValue = random.nextInt(6);
        return switch(randomValue){
            case 0 -> "A";
            case 1 -> "B";
            case 2 -> "C";
            case 3 -> "D";
            case 4 -> "E";
            case 5 -> "F";
            default -> "";
        };
    }

    public String randomCharacter2(){
        int randomValue = random.nextInt(6);
        return switch(randomValue){
            case 0 -> "A";
            case 1 -> "B";
            case 2 -> "C";
            case 3 -> "D";
            case 4 -> "E";
            case 5 -> "F";
            default -> "";
        };
    }

    public static void main(String[] args) {
        System.out.println(new ModelWithRandomMethod().randomCharacter());
    }

}
