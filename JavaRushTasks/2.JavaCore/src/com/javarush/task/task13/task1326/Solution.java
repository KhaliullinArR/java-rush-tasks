package com.javarush.task.task13.task1326;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine())) {
            byte[] memory = new byte[65365];
            int size;
            while (fileInputStream.available() > 0) {
                size = fileInputStream.read(memory);
                byte[] m = Arrays.copyOfRange(memory,0,size);
                String[] s = new String(m).split(System.lineSeparator());
                for (String s1 : s) {
                    int temp = Integer.parseInt(s1);
                    if (temp % 2 == 0) arrayList.add(temp);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(arrayList);
       arrayList.forEach(System.out::println);

    }
}
//D:\Важное\IDEA_Project\JavaRushTasks\2.JavaCore\src\com\javarush\task\task13\task1326\Input