package com.dmdev.hw8.Task1;

import java.util.*;

public class ChatsDemo {
    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("News", 1005));
        chats.add(new Chat("IT", 900));
        chats.add(new Chat("EnglishClub", 1001));
        chats.add(new Chat("HomeTips", 1001));
        chats.add(new Chat("Leisure", 999));
        for (Iterator<Chat> iterator = chats.iterator(); iterator.hasNext(); ) {
            Chat chat = iterator.next();
            if (chat.getQuantity() < 1000) {
                iterator.remove();
            }
        }
        chats.sort(Comparator.comparing(Chat::getQuantity, Comparator.reverseOrder()).thenComparing(Chat::getName));
    }
}
