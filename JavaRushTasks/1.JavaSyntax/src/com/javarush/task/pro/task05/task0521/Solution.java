package com.javarush.task.pro.task05.task0521;

/* 
Выполнение фрагмента кода
*/

import java.sql.SQLOutput;

public class Solution {

    public static int result = 45967;

    public static void main(String[] args) {
        String loop = "    for (double fahrenheit = -459.67; fahrenheit < 451; fahrenheit += 40) {\n";
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println(loop);
    }
}

