package com.dmdev.hw4;

import java.util.Arrays;

public class Appartment {
    private final int number;
    final Room[] rooms;

    Appartment(int number, Room[] rooms) {
        this.number = number;
        this.rooms = rooms;
    }

    void print() {
        System.out.println("В квартире # " + this.number + " количество комнат " + this.rooms.length);
    }
}
