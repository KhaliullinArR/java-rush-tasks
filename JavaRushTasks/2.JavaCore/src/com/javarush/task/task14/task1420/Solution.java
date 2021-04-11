package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static int mostGreatestDivisor(int a, int b){
        if(a == b) return a;
        if(a > b) return mostGreatestDivisor(a-b,b);
        else return mostGreatestDivisor(b-a,a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
        a = Integer.parseInt(bufferedReader.readLine());
        b = Integer.parseInt(bufferedReader.readLine());
        if(a < 1 || b < 1) throw new Exception();
        System.out.println(mostGreatestDivisor(a, b));
    }
}
