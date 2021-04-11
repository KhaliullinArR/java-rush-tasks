package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultOutput = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        testString.printSomething();

        System.setOut(defaultOutput);

        String text = byteArrayOutputStream.toString().replaceAll(System.lineSeparator(),"");
        switch (text.split(" ")[1]) {
            case "+" :   System.out.println(text + (Integer.parseInt(text.split(" ")[0]) + Integer.parseInt(text.split(" ")[2])));
            break;
            case "-" :   System.out.println(text + (Integer.parseInt(text.split(" ")[0]) - Integer.parseInt(text.split(" ")[2])));
            break;
            case "*" :   System.out.println(text + (Integer.parseInt(text.split(" ")[0]) * Integer.parseInt(text.split(" ")[2])));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

