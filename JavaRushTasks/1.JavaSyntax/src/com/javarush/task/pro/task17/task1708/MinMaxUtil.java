package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.util.Arrays;

public class MinMaxUtil {
    public static int min(int a, int b){
        return Math.min(a, b);
    }

    public static int min(int a, int b, int c){
        return min(a, min(b,c));
    }

    public static int min(int a, int b, int c, int d){
        return min(min(a,b), min(d, c));
    }

    public static int min(int a, int b, int c, int d, int e){
        return min(min(min(a,b), min(d, c)), e);
    }

    public static int max(int a, int b){
        return Math.max(a, b);
    }

    public static int max(int a, int b, int c){
        return max(a, max(b,c));
    }

    public static int max(int a, int b, int c, int d){
        return max(max(a,b), max(d, c));
    }

    public static int max(int a, int b, int c, int d, int e){
        return max(max(max(a,b), max(d, c)), e);
    }

}
