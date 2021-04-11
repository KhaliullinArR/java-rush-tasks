package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream file;
        String name = null;
        try {
                while (true){
                    name = bufferedReader.readLine();
                   file = new FileInputStream(name);
                   file.close();
                }

        } catch (Exception e) {
            System.out.println(name);
        }
    }
}
