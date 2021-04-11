package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String file = bfr.readLine();
        PrintStream defaultOutput = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        testString.printSomething();

        System.setOut(defaultOutput);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
        }

        System.out.println(byteArrayOutputStream.toString());

        bfr.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

