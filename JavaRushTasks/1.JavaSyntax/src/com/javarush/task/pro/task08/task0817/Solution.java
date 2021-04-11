package com.javarush.task.pro.task08.task0817;

public class Solution {//20

    public static void main(String[] args) {
        int a = 3;
        int b = ++a + (a-- * ++a);

        System.out.println(b);
    }
}