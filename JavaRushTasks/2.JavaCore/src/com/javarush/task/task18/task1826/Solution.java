package com.javarush.task.task18.task1826;

import java.io.*;
import java.util.Arrays;

/* 
Шифровка
*/

public class Solution {
    public static int key = 23;
    public static FileInputStream fli;
    public static FileOutputStream flo;

    public static void Encrypt() throws IOException {
        while (fli.available()>0){
            int data = fli.read();
            flo.write(Math.floorMod(data+key,256));
        }
    }

    public static void Decrypt() throws IOException {
        while (fli.available()>0){
            int data = fli.read();
            flo.write(Math.floorMod(data-key,256));
        }
    }


    public static void main(String[] args) throws IOException {
         fli = new FileInputStream(args[1]);
         flo = new FileOutputStream(args[2]);

        if ((args[0].equals("-d"))) {
            Decrypt();
        } else if((args[0].equals("-e"))) {
            Encrypt();
        }else System.out.println("Wrong command!");

        flo.close();
        fli.close();

    }

}
