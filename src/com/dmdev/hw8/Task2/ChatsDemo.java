package com.dmdev.hw8.Task2;

import java.util.*;

public class ChatsDemo {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Dmitry", 20));
        users.add(new User(2, "Pavel", 34));
        users.add(new User(3, "Yulia", 16));
        users.add(new User(4, "Evgeny", 17));
        users.add(new User(5, "Andrey", 19));
        users.add(new User(6, "Maria", 35));
        users.add(new User(7, "Eduard", 40));
        users.add(new User(8, "Alisa", 21));

        List<User> usersOverEighteen = new ArrayList<>();

        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("News", new ArrayList<>(List.of(users.get(0), users.get(1)))));
        chats.add(new Chat("IT", new ArrayList<>(List.of(users.get(2), users.get(3)))));
        chats.add(new Chat("EnglishClub", new ArrayList<>(List.of(users.get(4), users.get(5)))));
        chats.add(new Chat("HomeTips", new ArrayList<>(List.of(users.get(6), users.get(7)))));
        chats.add(new Chat("Leisure", new ArrayList<>(List.of(users.get(0), users.get(1)))));

        int quantity = 0;
        int ageSum = 0;
        int age;
        for (Chat chat : chats) {
            if (chat.getUsers().size() > 0) {
                for (Iterator<User> iterator = chat.getUsers().iterator(); iterator.hasNext(); ) {
                    User user = iterator.next();
                    age = user.getAge();
                    if (age > 18) {
                        usersOverEighteen.add(user);
                        iterator.remove();
                    } else {
                        ageSum += age;
                    }
                }
                quantity += chat.getUsers().size();
            }
        }
        System.out.println(ageSum / quantity);

    }
}
