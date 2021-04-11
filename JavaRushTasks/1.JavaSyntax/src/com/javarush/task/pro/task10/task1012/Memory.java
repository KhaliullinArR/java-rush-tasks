package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        int k = 0;
        while ( k < array.length && array[k] != null )k++;

        for (int i = k + 1; i < array.length ; i++) {
            if(array[i] == null) continue;

            array[k] = array[i];
            array[i] = null;
            k++;
        }
    }
}
