package com.javarush.task.pro.task12.task1214;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Останется только Java
*/

public class Solution {
    public static ArrayList<String> programmingLanguages = new ArrayList<>(Arrays.asList("C", "C++", "Python", "JavaScript", "Ruby", "Java", "Pascal"));

    public static void main(String[] args) {
        programmingLanguages.remove(0);
        programmingLanguages.remove(0);
        programmingLanguages.remove(0);
        programmingLanguages.remove(0);
        programmingLanguages.remove(0);
        programmingLanguages.remove(1);

        System.out.println(programmingLanguages);
    }
}
