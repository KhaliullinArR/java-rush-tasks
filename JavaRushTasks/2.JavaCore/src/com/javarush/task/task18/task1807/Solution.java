package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //',' --> 44, ASCII CODE
        try(FileInputStream fli = new FileInputStream(reader.readLine())) {
            while (fli.available()>0){
                if(fli.read()==(int)',')count++;
            }
        }
        System.out.println(count);
    }
}
