package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые частые байты
*/

public class Solution {
    public static HashMap<Byte, Integer>  counts =  new HashMap<>();
    static {
        for (int i = 0; i < 255; i++) {
            counts.put((byte)i,0);
        }
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            while (fileInputStream.available()>0){
                int key = fileInputStream.read();
                counts.replace((byte) key,counts.get((byte)key)+1);
            }
        }

        List<Map.Entry<Byte,Integer>> b = counts.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList());
        int max = b.get(b.size()-1).getValue();
        for (int i = b.size()-1; i >= 0; i--) {
            Map.Entry<Byte,Integer> temp = b.get(i);
            if(max == temp.getValue()) System.out.print(temp.getKey()+" ");
        }
    }
}
