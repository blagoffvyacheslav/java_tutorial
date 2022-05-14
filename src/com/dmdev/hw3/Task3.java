package com.dmdev.hw3;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * <p>
 * Пример:
 * <p>
 * [-4, -18]
 * <p>
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 * <p>
 * [1, 9, 3]
 */
public class Task3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 8, 0, -1, -2, 3, 4,};
        int[][] transformedNums = getNumbersBySignAndZero(nums);
        System.out.println("Преобразованные элементы: \n" + Arrays.toString(transformedNums[0]) + "\n" + Arrays.toString(transformedNums[1]) + "\n" + Arrays.toString(transformedNums[2]));
    }

    private static int[][] getNumbersBySignAndZero(int[] nums) {
        int positiveQn = 0;
        int negativeQn = 0;
        int zeroQn = 0;
        for (int num : nums) {
            if (num > 0) {
                positiveQn++;
            } else if (num < 0) {
                negativeQn++;
            } else {
                zeroQn++;
            }
        }
        int[] positiveNums = new int[positiveQn];
        int[] negativeNums = new int[negativeQn];
        int[] zeroNums = new int[zeroQn];

        for (int i = 0, j = 0, k = 0, l = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveQn++;
                positiveNums[j] = nums[i];
                j++;
            } else if (nums[i] < 0) {
                negativeQn++;
                negativeNums[k] = nums[i];
                k++;
            } else {
                zeroQn++;
                zeroNums[l] = nums[i];
                l++;
            }
        }
        return new int[][]{positiveNums, negativeNums, zeroNums};
    }
}
