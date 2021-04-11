package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println("earth".equals(Planet.EARTH));
    }

    public static Planet thePlanet;

    static{
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String name = br.readLine();

            if(name.equals(Planet.EARTH))thePlanet = Earth.getInstance();
            else if(name.equals(Planet.SUN))thePlanet = Sun.getInstance();
            else if(name.equals(Planet.MOON))thePlanet = Moon.getInstance();
            else thePlanet = null;


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
