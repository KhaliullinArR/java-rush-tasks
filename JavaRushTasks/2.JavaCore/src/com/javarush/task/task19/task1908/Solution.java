package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try(BufferedReader fli = new BufferedReader(new FileReader(bufferedReader.readLine()));
            BufferedWriter flo = new BufferedWriter(new FileWriter(bufferedReader.readLine()))){

            while (fli.ready()){
                String line = fli.readLine();

                Pattern pattern = Pattern.compile("\\b\\d+\\b");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find())flo.write(matcher.group()+" ");

                flo.newLine();
            }


        }

        bufferedReader.close();

    }
}
