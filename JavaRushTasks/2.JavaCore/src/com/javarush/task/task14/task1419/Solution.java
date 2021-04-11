package com.javarush.task.task14.task1419;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        Collections.addAll(exceptions,
                new RuntimeException(),
                new ArrayStoreException(),
                new Exception(),
                new ClassCastException(),
                new ArrayIndexOutOfBoundsException(),
                new EmptyStackException(),
                new IllegalArgumentException(),
                new IOException(),
                new FileNotFoundException());

    }
}
