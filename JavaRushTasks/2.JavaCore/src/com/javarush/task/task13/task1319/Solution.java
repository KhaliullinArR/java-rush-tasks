package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {

            String temp;

            while(true){
                temp = reader.readLine();
                if(temp.equals("exit")){
                    bufferedWriter.write(temp+System.lineSeparator());
                    break;
                }

                bufferedWriter.write(temp+System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
//D:\Важное\IDEA_Project\JavaRushTasks\2.JavaCore\src\com\javarush\task\task13\task1319\Output
