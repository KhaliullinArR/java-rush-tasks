package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        String name;
       try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){

           name = bufferedReader.readLine();

           if(name.equals("helicopter"))result = new Helicopter();
           else  if( name.equals("plane"))result = new Plane(Integer.parseInt(bufferedReader.readLine()));


       }catch (IOException e){
           e.printStackTrace();
       }
    }
}
