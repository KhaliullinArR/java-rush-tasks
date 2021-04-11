package com.javarush.task.pro.task11.task1127;

/* 
Телефон в наследство
*/

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SmartPhone implements SmartFunctions {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();
        switch (day)
        {
            case MONDAY:
                System.out.println("Понедельник");
            case TUESDAY:
                System.out.println("Вторник");
            case WEDNESDAY:
                System.out.println("Среда");
            case THURSDAY:
                System.out.println("Четверг");
            case FRIDAY:
                System.out.println("Пятница");
            case SATURDAY:
                System.out.println("Суббота");
            case SUNDAY:
                System.out.println("Воскресенье");
        }
    }
}
