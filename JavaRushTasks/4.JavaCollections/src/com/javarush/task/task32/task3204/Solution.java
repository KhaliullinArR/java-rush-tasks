package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }

    }

    public static ByteArrayOutputStream getPassword() {

        class  RandomUtil{
            Random random = new Random();

            public char getUpperChar(){
                return (char)((int)(random.nextDouble()*(91 - 65) + 65));
            }

            public char getPlainChar(){
                return (char)((int)(random.nextDouble()*(123 - 97) + 97));
            }

            public char getDigit(){
                return (char)((int)(random.nextDouble()*(58 - 48) + 48));
            }
        }
        RandomUtil randomUtil = new RandomUtil();
        Class<RandomUtil> randomUtilClass = RandomUtil.class;
        Method[] methods = randomUtilClass.getDeclaredMethods();
        Queue<Method> arrayList = new LinkedList<>();
        Collections.addAll(arrayList, methods);
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            try {
                if(arrayList.isEmpty())Collections.addAll(arrayList, methods);
                Collections.shuffle((List<?>) arrayList);
                password.append(arrayList.poll().invoke(randomUtil));

            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(password.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }
}
