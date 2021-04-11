package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try(BufferedReader fli = new BufferedReader(new FileReader(bufferedReader.readLine()));
            BufferedWriter flo = new BufferedWriter(new FileWriter(bufferedReader.readLine()))){

            while (fli.ready()){
                String line = fli.readLine();
                flo.write(line.replaceAll("\\p{Punct}",""));
            }

          
        }

        bufferedReader.close();
    }
}
/*
D:\Projects\IDEA_PROJECTS\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1910\texst
D:\Projects\IDEA_PROJECTS\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1910\out*/
