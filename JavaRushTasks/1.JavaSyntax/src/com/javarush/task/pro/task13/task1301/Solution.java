package com.javarush.task.pro.task13.task1301;

import java.util.Collections;
import java.util.HashSet;

/* 
Оформляем возврат
*/

public class Solution {

    public static void main(String[] args) {
        String[] array = {"Через", "три", "года", "я", "буду", "Senior", "Java", "Developer"};
        for(String s : array) {
            System.out.println(s);
        }
        System.out.println("___________________________________");

        HashSet<String> hashSet = arrayToHashSet(array);
        for(String s : hashSet) {
            System.out.println(s);
        }
    }

    public static HashSet<String> arrayToHashSet(String[] strings) {
        HashSet<String> hashSet = new HashSet<>();
        for (String string : strings) {
            hashSet.add(string);
        }

        return hashSet;
    }

}
