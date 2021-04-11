package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник:)
*/

public class Solution {

    static Date birthDate = new Date(120, Calendar.MARCH, 17);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String result = "";
        int day = date.getDay();
        switch (day) {
            case 0 -> result = "воскресенье";
            case 1 -> result = "понедельник";
            case 2 -> result = "вторник";
            case 3 -> result = "среда";
            case 4 -> result = "четверг";
            case 5 -> result = "пятница";
            case 6 -> result = "суббота";
        }
        return result;
    }
}
