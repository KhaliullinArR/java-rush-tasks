package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> strings = Files.readAllLines(Path.of(scanner.nextLine()));
            for (String string : strings) {
                for (char c: string.toCharArray()) {
                    if(c != ' ' &&  c != ',' && c != '.') System.out.print(c);
                }
                System.out.println();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

