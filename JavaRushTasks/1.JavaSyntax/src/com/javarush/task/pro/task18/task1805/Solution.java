package com.javarush.task.pro.task18.task1805;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Прощание с лямбда-выражением
*/

public class Solution {

    public static void main(String[] args) {
        var strings = new ArrayList<String>();

        Collections.addAll(strings, "JavaRush", "Amigo", "Java Developer", "CodeGym");

        sortStringsByLength(strings);
        strings.forEach(System.out::println);
    }

    public static void sortStringsByLength(ArrayList<String> strings) {

        Collections.sort(strings,new StringComparator());
    }
}
