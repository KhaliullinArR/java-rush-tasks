package com.javarush.task.pro.task10.task1003;

/* 
Построим новый бизнес-комплекс JavaRush Business Center
*/

public class Skyscraper {
    private int floorsCount;
    private String developer;

    public Skyscraper(int floorsCount, String developer) {
        this.floorsCount = floorsCount;
        this.developer = developer;
    }

    public Skyscraper() {
        floorsCount = 5;
        developer = "JavaRushDevelopment";
    }

    //напишите тут ваш код

    public static void main(String[] args) {
        var skyscraper = new Skyscraper();
        var skyscraperUnknown = new Skyscraper(50, "Неизвестно");
    }
}
