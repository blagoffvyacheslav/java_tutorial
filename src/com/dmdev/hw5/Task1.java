package com.dmdev.hw5;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */
public class Task1 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("aabc Ccpddd Dio OsfWw".replaceAll(" ", "").toUpperCase());
        System.out.println(s);
        for (int i = 0; i < s.length(); ) {
            if ((i > 0) && (s.charAt(i - 1) == s.charAt(i))) {
                s.deleteCharAt(i);
            } else {
                i++;
            }
        }
        System.out.println(s);
    }
}
