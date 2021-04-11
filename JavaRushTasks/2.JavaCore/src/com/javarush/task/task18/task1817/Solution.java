package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int whitespaceCounts = 0;
        int lettersCount = 0;

        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            while (fileInputStream.available()>0){
                int symbol = fileInputStream.read();
                lettersCount++;
                if(symbol==(int)' ')whitespaceCounts++;
            }

        }
        System.out.printf("%.2f",(((float)whitespaceCounts)/lettersCount)*100);
    }
}
