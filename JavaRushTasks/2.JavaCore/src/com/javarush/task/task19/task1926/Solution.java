package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader flr = new BufferedReader(new FileReader(reader.readLine()))) {
           flr.lines().forEach(x->{
               System.out.println(new StringBuilder(x).reverse());
           });
        }
    }
}
