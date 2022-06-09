package com.dmdev.hw8.Task2;

import java.util.ArrayList;

public class Chat {
    private final String name;
    private final ArrayList<User> users;

    public Chat(String name, ArrayList<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Chat{" + "name='" + name + '\'' + ", users=" + users + '}';
    }
}
