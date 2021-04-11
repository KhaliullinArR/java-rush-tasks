package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultOutput = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream wrapperOutput = new PrintStream(byteArrayOutputStream);

        System.setOut(wrapperOutput);

        testString.printSomething();

        System.setOut(defaultOutput);

        String text = byteArrayOutputStream.toString().replaceAll("te","??");

        System.out.println(text);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
