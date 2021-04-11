package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        try(BufferedReader flr = new BufferedReader(new FileReader(args[0]));){
            flr.lines().forEach(x->{
                String[] eachPerson = x.split(" ");
                map.put(eachPerson[0],map.getOrDefault(eachPerson[0],0d)+Double.parseDouble(eachPerson[1]));
            });
            map.forEach((k, v)-> System.out.println(k+" "+v));
        }

    }
}
