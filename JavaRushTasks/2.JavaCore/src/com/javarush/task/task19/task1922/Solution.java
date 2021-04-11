package com.javarush.task.task19.task1922;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader flr = new BufferedReader(new FileReader(bfr.readLine()))){
            int count= 0;
            for (String s : flr.lines().collect(Collectors.toCollection(ArrayList::new))){
                for (String s1 : s.split(" ")) {
                    if(words.contains(s1))count++;
                    if(count>2)break;
                }
                if(count==2) System.out.println(s);
                count=0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
