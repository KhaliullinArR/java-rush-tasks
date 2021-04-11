package com.javarush.task.task18.task1820;

import java.awt.geom.Arc2D;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();

        List<String> integers;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file1))) {
            String[] numbers = fileReader.readLine().split(" ");
            integers = Arrays.stream(numbers).map(x ->String.valueOf((int)Math.round(Double.parseDouble(x)))).collect(Collectors.toList());
        }

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file2))) {
            for (String integer : integers) {
                printWriter.write(integer+" ");
            }
        }

    }
}
