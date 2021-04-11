package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file;
        while (!(file=reader.readLine()).equals("exit")){
            new ReadThread(file).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private Map<Character, Integer> map = new HashMap<>();

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try (FileReader fileReader = new FileReader(fileName)) {

                while (fileReader.ready()){
                    char symbol = (char) fileReader.read();
                    if(map.containsKey(symbol))map.put(symbol,map.get(symbol)+1);
                    else map.put(symbol,1);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            resultMap.put(fileName,(int)map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey());
        }

    }
}
