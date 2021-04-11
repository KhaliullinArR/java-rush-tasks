package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Byte> counts =  new TreeSet<>(Comparator.comparingInt(x->x));



        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            while (fileInputStream.available()>0){
                int key = fileInputStream.read();
                counts.add((byte)key);
            }
        }
        counts.forEach(x -> System.out.print(x+" "));

    }
}
