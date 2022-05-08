package com.dmdev.hw1;

import java.util.Scanner;

/**
 В переменной minutes лежит число от 0 до 59.
 Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).

 Протестировать функцию в main.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("minutes: ");
        int minutes = scanner.nextInt();
        getQuarter(minutes);
    }

    private static void getQuarter(int minutes) {
        if (minutes >= 0 && minutes <= 59){
            int quarter;
            if (minutes <= 14){
                quarter = 1;
            }
            else if (minutes<=29){
                quarter = 2;
            }
            else if (minutes<=44){
                quarter = 3;
            }
            else {
                quarter = 4;
            }

            System.out.println("Минут: "+minutes+" "+"Четверть часа: "+quarter);
        }
        else{
            System.out.println("Введенные минут не лежат в промежутке (0..59)");
        }
    }

}
