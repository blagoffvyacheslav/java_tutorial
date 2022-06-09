package com.dmdev.hw8.Task1;

public class Chat {
    private final String name;
    private final int quantity;

    public Chat(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Chat{" + "name='" + name + '\'' + ", quantity=" + quantity + '}';
    }
}
