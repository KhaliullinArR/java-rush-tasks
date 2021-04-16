package com.javarush.task.task32.task3202;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if(is == null)return new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        while (is.available() > 0) {
            char[] buff = new char[2048];
            int count = inputStreamReader.read(buff);
            sw.write(buff, 0, count);
        }
        return sw;
    }
}
