package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws  IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try(FileReader fli = new FileReader(bufferedReader.readLine());
            FileWriter flo = new FileWriter(bufferedReader.readLine())){

            for (int i = 0; fli.ready(); i++) {
                if(i%2==1)flo.write(fli.read());
                else  fli.skip(1);
            }

        }

        bufferedReader.close();
    }
}
//D:\Projects\IDEA_PROJECTS\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1906\text
//D:\Projects\IDEA_PROJECTS\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1906\output