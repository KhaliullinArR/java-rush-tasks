package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1,"один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bfr = new BufferedReader(new FileReader(reader.readLine()))) {
            Pattern pattern = Pattern.compile("\\b(\\d|10|11|12)\\b");
            ArrayList<String> arrayList = bfr.lines().collect(Collectors.toCollection(ArrayList::new));
            for (String s : arrayList) {
                int lastIndex = 0;
                StringBuilder output = new StringBuilder();
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()){
                    output.append(s,lastIndex, matcher.start())
                            .append(map.get(Integer.parseInt(matcher.group())));

                    lastIndex = matcher.end();
                }
                if(lastIndex < s.length()){
                    output.append(s,lastIndex,s.length());
                }
                System.out.println(output);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
