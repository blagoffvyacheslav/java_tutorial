package com.dmdev.hw4;

import java.util.Arrays;

public class Floor {
    private final int number;
    final Appartment[] appartments;

    Floor(int number, Appartment[] appartments){
        this.number = number;
        this.appartments = appartments;
    }

    void print(){
        System.out.println("На этаже # " + this.number + " количество квартир " + this.appartments.length);
    }
}
