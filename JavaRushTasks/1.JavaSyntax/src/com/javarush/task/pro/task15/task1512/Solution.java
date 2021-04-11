package com.javarush.task.pro.task15.task1512;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 
Задом наперед
*/

public class Solution {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printSomething(scanner.nextLine());
        String result = outputStream.toString();
        byte[] reverseByte = result.getBytes();
        for (int i = 0; i < reverseByte.length/2; i++) {
            byte temp = reverseByte[i];
            reverseByte[i] = reverseByte[reverseByte.length-i-1];
            reverseByte[reverseByte.length-i-1] = temp;
        }
        outputStream.reset();
        outputStream.write(reverseByte);
        System.out.println(outputStream.toString());
    }

    public static void printSomething(String str) {
        stream.print(str);
    }
}
