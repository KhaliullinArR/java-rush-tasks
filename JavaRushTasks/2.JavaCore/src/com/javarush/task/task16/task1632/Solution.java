package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);



    static {
        Collections.addAll(threads,
                new Thread1(),
                new Thread2(),
                new Thread3(),
                new Thread4(),
                new Thread5());
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
          for (;;);
        }
    }


    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                for (;;)Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                for (;;){
                    System.out.println("Ура");
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
            }
        }
    }

    public static class Thread5 extends Thread {



        @Override
        public void run() {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                int sum = 0;
                try {
                    while (true){
                        sum+=Integer.parseInt(bufferedReader.readLine());
                    }
                } catch (NumberFormatException e) {
                    System.out.println(sum);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {


    }
}