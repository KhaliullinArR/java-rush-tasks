package com.javarush.task.pro.task14.task1416;

/* 
Логирование стектрейса
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Solution {

    public static ArrayList<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        String string = "";
        Random r = new Random();
        int low = 97;
        int high = 123;
        int result = r.nextInt(high-low) + low;

        int size;
        for (int i = 0; i <  750; i++) {
            //size = r.nextInt(2) + 1;
            for (int i1 = 0; i1 < 4; i1++) {
                characters.add((char) (r.nextInt(high-low) + low));
            }
            for (Character character : characters) {
                string = string + character;
            }
            System.out.println(string);
            string = "";
            characters = new ArrayList<>();
        }

    }

    static void dangerousMethod() throws Exception {
        Random random = new Random();
        System.out.println('a');
    }
}
