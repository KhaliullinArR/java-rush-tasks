package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bfr.readLine();
        String file2 = bfr.readLine();
        String file3 = bfr.readLine();

        try (FileOutputStream outputStream = new FileOutputStream(file1)) {
            try (FileInputStream fileInputStream2 = new FileInputStream(file2)) {
                while (fileInputStream2.available()>0)outputStream.write(fileInputStream2.read());
            }

            try (FileInputStream fileInputStream3 = new FileInputStream(file3)) {
                while (fileInputStream3.available()>0)outputStream.write(fileInputStream3.read());
            }
        }

    }
}
