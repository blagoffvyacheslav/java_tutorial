package com.dmdev.hw1;

import java.util.Scanner;


/**
 Даны два прямоугольных треугольника.
 Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.

 Для этого понадобится написать 2 функции.
 Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 Учитывать, что площадь может быть вещественным числом.
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a1: ");
        double a1 = scanner.nextDouble();
        System.out.println("b1: ");
        double b1 = scanner.nextDouble();
        System.out.println("a2: ");
        double a2 = scanner.nextDouble();
        System.out.println("b2: ");
        double b2 = scanner.nextDouble();
        double s1 = calcSquare(a1, b1);
        double s2 = calcSquare(a2, b2);
        compareSquares(s1, s2);
    }

    private static double calcSquare(double a, double b) {
       return a * b;
    }

    private static void compareSquares(double s1, double s2) {
        if (s1 > s2){
            System.out.println("Первый треугольник больше второго");
        }
        else if (s1 == s2){
            System.out.println("Первый треугольник равен второму");
        }
        else{
            System.out.println("Первый треугольник меньше второго");
        }
    }
}
