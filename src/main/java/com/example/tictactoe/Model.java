package com.example.tictactoe;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Model {

    StringProperty cell1 = new SimpleStringProperty("");
    StringProperty cell2 = new SimpleStringProperty("");
    StringProperty cell3 = new SimpleStringProperty("");
    StringProperty cell4 = new SimpleStringProperty("");
    StringProperty cell5 = new SimpleStringProperty("");
    StringProperty cell6 = new SimpleStringProperty("");
    StringProperty cell7 = new SimpleStringProperty("");
    StringProperty cell8 = new SimpleStringProperty("");
    StringProperty cell9 = new SimpleStringProperty("");



    public void cellClicked(int id) {
        switch(id){
            case 1-> setCell1("X");
            case 2-> setCell2("X");
            case 3-> setCell3("X");
            case 9-> setCell9("X");

        }
    }

    public String getCell1() {
        return cell1.get();
    }

    public StringProperty cell1Property() {
        return cell1;
    }

    public void setCell1(String cell1) {
        this.cell1.set(cell1);
    }

    public String getCell2() {
        return cell2.get();
    }

    public StringProperty cell2Property() {
        return cell2;
    }

    public void setCell2(String cell2) {
        this.cell2.set(cell2);
    }

    public String getCell3() {
        return cell3.get();
    }

    public StringProperty cell3Property() {
        return cell3;
    }

    public void setCell3(String cell3) {
        this.cell3.set(cell3);
    }

    public String getCell4() {
        return cell4.get();
    }

    public StringProperty cell4Property() {
        return cell4;
    }

    public void setCell4(String cell4) {
        this.cell4.set(cell4);
    }

    public String getCell5() {
        return cell5.get();
    }

    public StringProperty cell5Property() {
        return cell5;
    }

    public void setCell5(String cell5) {
        this.cell5.set(cell5);
    }

    public String getCell6() {
        return cell6.get();
    }

    public StringProperty cell6Property() {
        return cell6;
    }

    public void setCell6(String cell6) {
        this.cell6.set(cell6);
    }

    public String getCell7() {
        return cell7.get();
    }

    public StringProperty cell7Property() {
        return cell7;
    }

    public void setCell7(String cell7) {
        this.cell7.set(cell7);
    }

    public String getCell8() {
        return cell8.get();
    }

    public StringProperty cell8Property() {
        return cell8;
    }

    public void setCell8(String cell8) {
        this.cell8.set(cell8);
    }

    public String getCell9() {
        return cell9.get();
    }

    public StringProperty cell9Property() {
        return cell9;
    }

    public void setCell9(String cell9) {
        this.cell9.set(cell9);
    }
}
