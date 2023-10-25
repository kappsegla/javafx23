package com.example.tictactoe;

public class Model {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
       this.value = value;
    }

    public boolean checkText(String text){
        return check(text);
    }

    private static boolean check(String text) {
        return text.isEmpty();
    }


    public static int add(int a, int b){
        return a + b;
    }
    //0, 1, 9, 10  - border values should be tested
    //-1 ?   - input that is common to fail
    public static int intervall(int value){
        if( value > 0 && value < 10)
            return 0;
        else
            return value;
    }


}
