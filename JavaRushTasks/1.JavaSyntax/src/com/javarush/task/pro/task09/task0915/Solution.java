package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "com.javarush.task.pro.task09.task0915";
        String[] tokens = getTokens(packagePath, ".a");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer= new StringTokenizer(query,delimiter);
        String[] strings = new String[stringTokenizer.countTokens()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = stringTokenizer.nextToken();
        }
        return strings;
    }
}
