package com.javarush.task.pro.task10.task1011;

import java.util.Objects;

/* 
Создаем свой hashCode
*/

public class Car {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public int hashCode() {
        int sum = 0;
        byte[] modelSymbols = model.getBytes();
        for (byte temp : modelSymbols) {
            sum += temp;
        }

        int yearBit = year << (year * 3);

        return (sum + yearBit) >> 5;
    }

    //напишите тут ваш код

    public static void main(String[] args) {
        var lamborghini = new Car("Lamborghini", 2020);
        var lamborghini1 = new Car("Lamborghini", 2020);
        var ferrari = new Car("Ferrari", 2020);
        var ferrari1 = new Car("Ferrari", 2020);
        var bugatti = new Car("Bugatti", 2020);
        var bugatti1 = new Car("Bugatti", 2020);
        System.out.println(ferrari.hashCode() == ferrari.hashCode());
        System.out.println(lamborghini.hashCode() == lamborghini1.hashCode());
        System.out.println(ferrari.hashCode() == ferrari1.hashCode());
        System.out.println(bugatti.hashCode() == bugatti1.hashCode());
        System.out.println(bugatti.hashCode() == lamborghini.hashCode());
        System.out.println(lamborghini.hashCode() == ferrari.hashCode());
    }
}
