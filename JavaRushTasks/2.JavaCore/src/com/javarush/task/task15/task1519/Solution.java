package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d*)?$");
        String temp = bufferedReader.readLine();
        Matcher matcher;
        while (true){
            if(temp.equals("exit"))break;
            matcher = pattern.matcher(temp);

            if(matcher.find()){
                try{
                    Integer integer = Integer.parseInt(temp);
                    if(integer > 0 && integer < 128)print(Short.parseShort(integer.toString()));
                    else print(integer);
                }catch (NumberFormatException e){
                    print(Double.parseDouble(temp));
                }
            }else print(temp);
            temp = bufferedReader.readLine();
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
