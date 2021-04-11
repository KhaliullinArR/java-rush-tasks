package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bfr.readLine();
        String file2 = bfr.readLine();
        byte[] data1;
        byte[] data2;

        try ( FileInputStream fl1 = new FileInputStream(file1);
        FileInputStream fl2 = new FileInputStream(file2)) {
            data1 = new byte[fl1.available()];
            fl1.read(data1);

            data2 = new byte[fl2.available()];
            fl2.read(data2);

        }

        try (FileOutputStream flo = new FileOutputStream(file1)) {
            flo.write(data2);
            flo.write(data1);
        }


    }
}
