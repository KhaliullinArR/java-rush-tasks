package com.javarush.task.task14.task1408;

 class BelarusianHen extends Hen {
     @Override
     int getCountOfEggsPerMonth() {
         return 11;
     }

     @Override
    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",super.getDescription(), Country.BELARUS,getCountOfEggsPerMonth());
    }
}