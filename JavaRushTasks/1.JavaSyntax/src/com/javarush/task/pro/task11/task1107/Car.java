package com.javarush.task.pro.task11.task1107;

/* 
Двигатель — сердце автомобиля
*/

public class Car {
    Engine engine = new Engine();

    public static void main(String[] args) {
        //напишите тут ваш код
    }

    public class Engine{

        private boolean isRunning;

       public void start(){
            isRunning = true;
        }

       public void  stop(){
            isRunning = false;
        }

    }
}
