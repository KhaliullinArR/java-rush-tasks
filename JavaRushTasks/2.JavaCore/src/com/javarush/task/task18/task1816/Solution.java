package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            while (fileInputStream.available()>0){
                int symbol = fileInputStream.read();
                if((symbol>=97)&&(symbol<=122))count++;
                else if((symbol>=65)&&(symbol<=90))count++;
            }
        }
        System.out.println(count);
    }
}
//        97        a
//        122       z
//        65        A
//        90        Z