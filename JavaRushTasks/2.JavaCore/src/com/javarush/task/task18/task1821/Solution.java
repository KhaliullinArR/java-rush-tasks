package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {

    public static void main(String[] args) {
       SortedMap<Character, Integer> sortedMap = new TreeMap<>((o1, o2) -> (int) o1 - o2);
        try (FileReader fileReader = new FileReader(args[0])) {

            while (fileReader.ready()){
                char symbol = (char) fileReader.read();
                if(sortedMap.containsKey(symbol))sortedMap.put(symbol,sortedMap.get(symbol)+1);
                else sortedMap.put(symbol,1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        sortedMap.forEach((x,y)-> System.out.println(x+" "+y));

    }
}
