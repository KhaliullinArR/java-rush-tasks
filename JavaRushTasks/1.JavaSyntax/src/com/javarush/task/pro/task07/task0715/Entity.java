package com.javarush.task.pro.task07.task0715;

/* 
Наследование методов
*/

public class Entity {
    public static int N = 1000;

    public static void drawValue(double y) {
        int value = (int) (y * N) + N;
        for (int i = 0; i < 2 * N; i++) {
            char c = i == N ? '|' : '.';
            if (i == value)
                c = '*';
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10 * N; i++) {
            double x = i * 1.0 / N;
            double y = Math.sin(x);
            drawValue(y);
        }
    }
}
