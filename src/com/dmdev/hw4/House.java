package com.dmdev.hw4;

import java.util.Arrays;

public class House {
    private final int number;
    final Floor[] floors;

    House(int number, Floor[] floors){
        this.number = number;
        this.floors = floors;
    }

    void print(){
        System.out.println("Дом # " + this.number + " содержит этажей " + this.floors.length);
    }
}
