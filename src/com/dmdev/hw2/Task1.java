package com.dmdev.hw2;

import java.util.Scanner;

/**
 Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция - нечетных).

 Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        int num = scanner.nextInt();
        System.out.println(evenQuantity(num) + " четные цифры");
        System.out.println(oddQuantity(num) + " нечетные цифры");
    }

    private static int evenQuantity(int n) {
        int i = 0;
        int digit;
        String message = "";
        if (n == 0){
            System.out.println(0);
            return 1;
        }

        while (n>0){
            digit = n % 10;
            if (digit % 2 == 0){
                i++;
                message = message + digit + " ";
            }
            n /= 10;
        }
        System.out.println(message);
        return i;
    }

    private static int oddQuantity(int n) {
        int i = 0;
        int digit;
        String message = "";

        while (n>0){
            digit = n % 10;
            if (digit % 2 == 1){
                i++;
                message = message + digit + " ";
            }
            n /= 10;
        }
        System.out.println(message);
        return i;
    }
}
