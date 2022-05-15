package com.dmdev.hw5;

import java.util.Arrays;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * <p>
 * Написать 2 метода:
 * <p>
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * <p>
 * Посчитать сумму всех чисел из строки
 * <p>
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2 {
    public static void main(String[] args) {
        int[] nums = getNums("Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?");
        System.out.println("Массив: " + Arrays.toString(nums));
        System.out.println("Сумма элементов: " + sum(nums));
    }

    protected static int[] getNums(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                n++;
            }
        }
        int[] values = new int[n];
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                values[j] = Character.getNumericValue(s.charAt(i));
                j++;
            }
        }
        return values;
    }

    protected static int sum(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        return s;
    }
}
