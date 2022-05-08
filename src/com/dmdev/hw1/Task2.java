package com.dmdev.hw1;

import java.util.Scanner;

/**
 Даны 3 переменные:

 - operand1 (double)
 - operand2 (double)
 - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)

 Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 Протестировать функцию в main.

 Например:
 Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 Результат: 34.5 (24.4 + 10.1)
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("operand1: ");
        double operand1 = scanner.nextDouble();
        System.out.println("operand2: ");
        double operand2 = scanner.nextDouble();
        System.out.println("operation: ");
        char operation = scanner.next().charAt(0);
        double res = calc(operand1, operand2, operation);
        System.out.println( "Результат: "+res);
    }

    private static double calc(double operand1, double operand2, char operation) {
       return switch(operation) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            case '%' -> operand1 % operand2;
            default -> 0; // операция не определена
        };
    }
}
