package com.dmdev.hw4;


/**
 * Представить в виде классов и их композиции следующую модель.
 * <p>
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * <p>
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * <p>
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * <p>
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * <p>
 * В каждом классе реализовать метод print, который на консоль выводит информацию об объекте (должны присутствовать все поля объекта!).
 * <p>
 * Например, метод print класса этаж должен выводить на консоль:
 * <p>
 * “Этаж 2, количество квартир 18”
 * <p>
 * Создание всех объектов вынести в отдельный класс с методом main.
 * <p>
 * Там же реализовать метод printAllInformation, который на вход принимает объект типа дом, и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
 */
public class AppartmentRunner {
    public static void main(String[] args) {
        Room room1 = new Room(true);
        Room room2 = new Room();
        Room room3 = new Room(false);
        Room room4 = new Room();
        Appartment appartment11 = new Appartment(1, new Room[]{room1, room2});
        Appartment appartment12 = new Appartment(2, new Room[]{room3});
        Floor floor1 = new Floor(1, new Appartment[]{appartment11, appartment12});
        Appartment appartment21 = new Appartment(1, new Room[]{room3});
        Appartment appartment22 = new Appartment(2, new Room[]{room4});
        Floor floor2 = new Floor(2, new Appartment[]{appartment21, appartment22});
        House house = new House(2, new Floor[]{floor1, floor2});
        printAllInformation(house);
    }

    static void printAllInformation(House house) {
        house.print();
        for (Floor floor : house.floors) {
            floor.print();
            for (Appartment appartment : floor.appartments) {
                appartment.print();
                for (Room room : appartment.rooms) {
                    room.print();
                }
            }
        }
    }
}
