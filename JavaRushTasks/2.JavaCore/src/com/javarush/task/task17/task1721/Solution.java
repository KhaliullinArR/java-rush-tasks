package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (BufferedReader fr1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader fr2 = new BufferedReader(new FileReader(reader.readLine()))) {
            while (fr1.ready()) allLines.add(fr1.readLine());
            while (fr2.ready()) forRemoveLines.add(fr2.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }


    }

    public void joinData() throws CorruptedDataException {
            if(allLines.containsAll(forRemoveLines))allLines.removeAll(forRemoveLines);
            else{
                allLines.clear();
                throw new CorruptedDataException();
            }
    }
}
//D:\Важное\IDEA_Project\JavaRushTasks\2.JavaCore\src\com\javarush\task\task17\task1721\input1
//D:\Важное\IDEA_Project\JavaRushTasks\2.JavaCore\src\com\javarush\task\task17\task1721\input2