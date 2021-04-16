package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw")) {
            int number = Integer.parseInt(args[1]);
            if(randomAccessFile.length() < number){
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write(args[2].getBytes());
            }else{
                randomAccessFile.seek(number);
                randomAccessFile.write(args[2].getBytes());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
