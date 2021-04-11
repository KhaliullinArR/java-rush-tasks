package com.javarush.task.pro.task17.task1716;

/* 
Дорожное движение
*/

public interface Vehicle {
    public default void start() {
        System.out.println("Начинаю движение.");
    }
    void move();
    public default void stop() {
        System.out.println("Останавливаюсь.");
    }
}
