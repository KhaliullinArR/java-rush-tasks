package com.javarush.task.pro.task08.task0810;

import java.util.concurrent.TimeUnit;

/* 
Таймер
*/

public class Solution {

    public static void setTimer(int days, int hours, int minutes, int seconds, int millis) throws InterruptedException {
        System.out.println("Таймер запущен!");
        TimeUnit.MILLISECONDS.sleep(millis);
        TimeUnit.SECONDS.sleep(seconds);
        TimeUnit.MINUTES.sleep(minutes);
        TimeUnit.HOURS.sleep(hours);
        TimeUnit.DAYS.sleep(days);
        System.out.println("♬ ♪ ♬♬♬♬ ♪♪♪♪");
    }
}
