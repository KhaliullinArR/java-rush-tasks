package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(FileInputStream fl1 = new FileInputStream(reader.readLine());
            FileOutputStream fl2 = new FileOutputStream(reader.readLine())){
            byte[] bytes = new byte[fl1.available()];
            fl1.read(bytes);
            for (int i = bytes.length-1; i >= 0; i--) {
                fl2.write(bytes[i]);
            }
        }
    }
}
//D:\Важное\IDEA_Project\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1809\input
//D:\Важное\IDEA_Project\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1809\output
