package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые редкие байты
*/

public class Solution {



    public static void main(String[] args) throws Exception {
        HashMap<Byte, Integer> counts =  new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            while (fileInputStream.available()>0){
                int key = fileInputStream.read();
                counts.putIfAbsent((byte)key, 0);
                counts.replace((byte) key, counts.get((byte)key)+1);
            }
        }

        List<Map.Entry<Byte,Integer>> list = counts.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList());
        int min = list.get(0).getValue();
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Byte,Integer> temp = list.get(i);
            if(min == temp.getValue()) System.out.print(temp.getKey()+" ");
            else break;
        }
    }
}
