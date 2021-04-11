package com.javarush.task.task15.task1530;

public class TeaMaker extends DrinkMaker{
    /*
"Берем чашку для латте"
"Заливаем молоком с пенкой"
"Делаем кофе"*/
    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    public void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем кипятком");
    }
}
