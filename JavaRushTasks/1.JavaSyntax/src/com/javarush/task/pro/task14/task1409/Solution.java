package com.javarush.task.pro.task14.task1409;

/* 
Пропускаем сквозь себя
*/

public class Solution {

    public static void main(String[] args)throws Exception {
        generateLuckyNumber();
        try{
            throw new RuntimeException();
        }catch (RuntimeException e){
            throw e;
        }catch (Exception e){
            System.out.println(e);
        }

    }

    static void generateLuckyNumber() throws Exception {
        int luckyNumber = (int) (Math.random() * 100);
        if (luckyNumber == 13) {
            throw new Exception("не повезло");
        }
        System.out.println("твое счастливое число: " + luckyNumber);
    }
}
