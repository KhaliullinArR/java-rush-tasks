package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            int number = Integer.parseInt(args[1]);
            raf.seek(number);
            byte[] bytes = new byte[args[2].getBytes().length];
            raf.read(bytes, 0, bytes.length);
            String text = new String(bytes);
            raf.seek(raf.length());
            if(text.equals(args[2]))raf.write("true".getBytes());
            else raf.write("false".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
