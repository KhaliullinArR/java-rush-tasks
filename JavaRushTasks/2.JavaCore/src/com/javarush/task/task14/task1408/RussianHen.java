package com.javarush.task.task14.task1408;

 class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 5;
    }

    @Override
    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",super.getDescription(), Country.RUSSIA,getCountOfEggsPerMonth());
    }
}