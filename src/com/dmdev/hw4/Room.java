package com.dmdev.hw4;

public class Room {
    private final boolean passage;

    Room() {
        this.passage = false;
    }

    Room(boolean passage) {
        this.passage = passage;
    }

    void print() {
        System.out.println("Комната " + (this.passage ? "проходная" : "не проходная"));
    }
}
