package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {
            int countOfWorlds = 0;
            while (fileReader.ready()){
                String line = fileReader.readLine();
                Pattern pattern = Pattern.compile("\\bworld\\b");
                Matcher matcher = pattern.matcher(line);
                for (;matcher.find();)countOfWorlds++;
            }

            System.out.println(countOfWorlds);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
