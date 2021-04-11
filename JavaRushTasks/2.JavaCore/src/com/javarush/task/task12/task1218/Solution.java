package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.Duck duck = solution.new Duck();
        Cl cl =  new Cl();
    }

    public interface CanFly {
         void fly();

         default int getCount(){
            return 0;
        }
    }

    public interface CanMove {
         void move();
    }

    public interface CanEat {
         void eat();
    }

    public class Dog implements  CanEat, CanMove{

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }

    public class Duck implements  CanMove, CanEat, CanFly{
        @Override
        public void fly() {

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }


    }

    public class Car implements CanMove {
        @Override
        public void move() {

        }
    }

    public class Airplane implements CanMove,CanFly{
        @Override
        public void fly() {

        }

        @Override
        public void move() {

        }
    }

    public static abstract  class Cloud{
        int a;
        int b;
        private static int count;

        {

            count = 0;

        }

        static {

            count = 0;


        }

        public  static void count(int a){

        }



    }

    public  static class Cl extends Cloud{

    }



}
