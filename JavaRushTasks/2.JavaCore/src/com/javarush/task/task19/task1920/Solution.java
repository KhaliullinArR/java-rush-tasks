package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Double> map = new TreeMap<>();
        try(BufferedReader flr = new BufferedReader(new FileReader(args[0]));){
            flr.lines().forEach(x->{
                String[] personAttributes = x.split(" ");
                map.put(personAttributes[0],map.getOrDefault(personAttributes[0],0d)+Double.parseDouble(personAttributes[1]));
            });
            double max =  map.values().stream().max(Double::compareTo).get();
            map.forEach((k, v)->{
                if(v == max) System.out.println(k);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
