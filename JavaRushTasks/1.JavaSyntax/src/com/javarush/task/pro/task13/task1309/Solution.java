package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
       grades.put("Кирил Кривенков", 2.0);
       grades.put("МИша Топала", 3.0);
       grades.put("Максим Физлик", 3.5);
       grades.put("Амиль Жирный", 3.5);
       grades.put("Олег Бочара", 3.5);
    }
}
