package com.javarush.task.task15.task1530;

public class LatteMaker extends DrinkMaker {

    /*
"Берем чашку для латте"
"Заливаем молоком с пенкой"
"Делаем кофе"*/

    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для латте");
    }

    @Override
    public void putIngredient() {
        System.out.println("Делаем кофе");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем молоком с пенкой");
    }
}
