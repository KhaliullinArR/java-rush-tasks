package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> files = new TreeMap<>();

        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher;
        String temp;

        while (!((temp= bfr.readLine()).equals("end"))){
            matcher = pattern.matcher(temp);
            matcher.find();
            files.put(temp,Integer.parseInt(matcher.group()));
        }

        List<String> f = files.entrySet().stream().sorted((Comparator.comparingInt(Map.Entry::getValue)))
                .collect(ArrayList::new,(r,o)->r.add(o.getKey()),ArrayList::addAll);
        try (FileOutputStream finalFile =new FileOutputStream(f.get(0).substring(0, f.get(0).lastIndexOf(".")))) {
            for (String s : f) {
                try (FileInputStream fl = new FileInputStream(s)) {
                  byte[] buffer = new byte[fl.available()];
                  fl.read(buffer);
                  finalFile.write(buffer);
                }
            }

        }

    }
}
