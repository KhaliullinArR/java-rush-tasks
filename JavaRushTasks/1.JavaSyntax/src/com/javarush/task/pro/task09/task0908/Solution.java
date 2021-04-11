package com.javarush.task.pro.task09.task0908;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    public static Map<String, String> rightHereMap = new HashMap<String, String>()
    {
        {
            put("0000", "0");
            put("0001", "1");
            put("0010", "2");
            put("0011", "3");
            put("0100", "4");
            put("0101", "5");
            put("0110", "6");
            put("0111", "7");
            put("1000", "8");
            put("1001", "9");
            put("1010", "a");
            put("1011", "b");
            put("1100", "c");
            put("1101", "d");
            put("1110", "e");
            put("1111", "f");
        }
    };

    public static void main(String[] args) {
        Math.random();
        String binaryNumber = "111100010101";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "fddfd1323";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }
    public static String toHex(String binaryNumber) {
        if(binaryNumber ==null || binaryNumber.equals(""))return "";
        StringBuilder bBuilder = new StringBuilder(binaryNumber);
        char[] binDigits = new char[bBuilder.length()];
        bBuilder.getChars(0,bBuilder.length(),binDigits,0);
        for (char hexDigit : binDigits) {
            if ((hexDigit == '0') || (hexDigit == '1')) continue;
            return "";
        }
        int temp;
        if(binaryNumber.length()%4!=0) temp =4-binaryNumber.length()%4;
        else temp = 0;
        StringBuilder binaryBuilder = new StringBuilder(binaryNumber);
        binaryBuilder.reverse();
        binaryBuilder.append("0".repeat(temp));
        binaryBuilder.reverse();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < binaryBuilder.length(); i+=4) {
            stringBuilder.append(rightHereMap.get(binaryBuilder.substring(i,i+4)));
        }
        return stringBuilder.toString();
    }
    public static String toBinary(String hexNumber) {
        if(hexNumber ==null || hexNumber.equals(""))return "";
        StringBuilder hexBuilder = new StringBuilder(hexNumber);
        char[] hexDigits = new char[hexBuilder.length()];
        hexBuilder.getChars(0,hexBuilder.length(),hexDigits,0);
        for (char hexDigit : hexDigits) {
            if (((hexDigit >= 'a') && (hexDigit <= 'f')) || ((hexDigit >= '0') && (hexDigit <= '9'))) continue;
            return "";
        }
        StringBuilder binBuilder = new StringBuilder();
        for (char hexDigit : hexDigits) {

            for (Map.Entry<String, String> entry : rightHereMap.entrySet()) {
                String temp = entry.getValue();
                if (temp.equals(String.valueOf(hexDigit))) binBuilder.append(entry.getKey());
            }
        }
        return binBuilder.toString();
    }
}
