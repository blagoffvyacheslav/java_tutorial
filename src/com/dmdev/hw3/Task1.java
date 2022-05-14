package com.dmdev.hw3;


import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * <p>
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции. main - только для тестирования написанного функционала.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] values = {3, -1, -10, 0};
        System.out.println("Массив положительных чисел: \n" + Arrays.toString(positiveNewAndMultiplyOld(values)));
    }

    private static int[] positiveNewAndMultiplyOld(int[] values) {
        int n = 0;

        for (int value : values) {
            if (value >= 0) {
                n++;
            }
        }
        int[] positiveValues = new int[n];
        for (int i = 0, j = 0; i < values.length; i++) {
            if (values[i] >= 0) {
                positiveValues[j] = values[i] * n;
                j++;
            }
        }
        return positiveValues;
    }
}
