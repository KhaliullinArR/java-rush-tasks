package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;
import java.util.Arrays;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        if(N % 2 == 0){
            for (int i = 0; i < N; i++) {
                System.out.println(arr[N-i-1]);
            }
        }else for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

}
