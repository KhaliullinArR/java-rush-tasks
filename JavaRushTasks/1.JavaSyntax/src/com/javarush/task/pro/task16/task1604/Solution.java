package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(2002,11,3);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        return switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1 -> "Воскресенье";
            case 2 -> "Понедельник";
            case 3 -> "Вторник";
            case 4 -> "Среда";
            case 5 -> "Четверг";
            case 6 -> "Пятница";
            case 7 -> "Суббота";
            default -> throw new IllegalStateException("Unexpected value: " + calendar.get(Calendar.DAY_OF_WEEK));
        };
    }
}
