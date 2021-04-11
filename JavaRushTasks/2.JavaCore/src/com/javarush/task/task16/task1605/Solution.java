package com.javarush.task.task16.task1605;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;

/* 
Поговорим о музыке
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        new B();
        //Thread violin = new Thread(new Violin("Player"));
        //violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class A{
        protected int a;
        public A() {
            this.a = 55;
            System.out.println(a);
        }
    }

    public static class B extends A {
        protected  int a;
        public B() {
            super.a = 32;
            System.out.println(a);
        }
    }



    public static class Violin implements MusicalInstrument {


        private String owner;

        @Override
        public void run() {
            LocalDateTime start = Instant.ofEpochMilli(startPlaying().getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
            sleepNSeconds(1);
            LocalDateTime stop = Instant.ofEpochMilli(stopPlaying().getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
            System.out.printf("Playing %d ms",stop.get(ChronoField.MILLI_OF_SECOND)-start.get(ChronoField.MILLI_OF_SECOND));
        }

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " is starting to play");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " is stopping playing");
            return new Date();
        }
    }
}
