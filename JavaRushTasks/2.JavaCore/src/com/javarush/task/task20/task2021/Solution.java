package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable {

    public Solution() throws NotSerializableException {
        throw new NotSerializableException();
    }

    public static class SubSolution extends Solution {
        public SubSolution() throws NotSerializableException {
        }
    }

    public static void main(String[] args) {

    }
}
