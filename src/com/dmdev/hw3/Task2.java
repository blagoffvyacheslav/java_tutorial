package com.dmdev.hw3;

import java.util.Arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы,
 * которые больше этого среднего арифметического.
 */
public class Task2 {
    public static void main(String[] args) {
        char[] chars = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        System.out.println("Преобразованные элементы: \n" + Arrays.toString(getNumbersCode(chars)));
    }

    private static int[] getNumbersCode(char[] chars) {
        int s = 0;
        int n = chars.length;
        int[] numericChars = new int[n];
        for (int i = 0; i < n; i++) {
            numericChars[i] = (int) chars[i];
            s += numericChars[i];
        }
        double average = s / (double) n;
        System.out.println("Больше " + average);
        for (int numericChar : numericChars) {
            if (numericChar > average) {
                System.out.println(numericChar);
            }
        }
        return numericChars;
    }

}
