package com.dmdev.hw2;

import java.util.Scanner;

/**
 Дано целое число.
 Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 Результат вывести на консоль.
 Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321

 Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        int num = scanner.nextInt();
        int reverse = reverseNum(num);
        System.out.println("Перевернутое число: "+reverse);
    }

    private static int reverseNum(int n) {
        int reversed = 0;
        while(n != 0) {

            int digit = n % 10;
            reversed = reversed * 10 + digit;

            n /= 10;
        }
        return reversed;
    }

}
