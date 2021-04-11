package com.javarush.task.pro.task05.task0508;

import java.util.Arrays;
import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        int N = 10;
        strings = new String[N];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            strings[i] = scanner.nextLine();
        }
        for (int i = 0; i < N; i++) {
            if (strings[i] == null) continue;
            String delete = strings[i];
            boolean flag = false;
            for (int j = i + 1; j < N; j++) {
                if (delete.equals(strings[j])) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int j = 0; j < N; j++) {
                    if (strings[j] == null) continue;
                    if (strings[j].equals(delete)) strings[j] = null;
                }
            }
        }

        Arrays.stream(strings).forEach(System.out::println);
    }
}
