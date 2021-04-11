package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try(BufferedReader fli = new BufferedReader(new FileReader(bufferedReader.readLine()));
            BufferedWriter flo = new BufferedWriter(new FileWriter(bufferedReader.readLine()))){

            while (fli.ready()){
                String line = fli.readLine();
                flo.write(line.replaceAll("\\.","!"));
                flo.newLine();
            }


        }

        bufferedReader.close();
    }
}
