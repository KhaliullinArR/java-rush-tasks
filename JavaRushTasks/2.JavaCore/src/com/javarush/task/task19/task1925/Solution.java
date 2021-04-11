package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader flr1 = new BufferedReader(new FileReader(args[0]));
             FileWriter flr2 = new FileWriter(args[1])) {
            boolean comma = true;
            ArrayList<String> arrayList = flr1.lines().flatMap(line-> Stream.of(line.split(" "))).collect(Collectors.toCollection(ArrayList::new));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i).length()>6) stringBuilder.append(arrayList.get(i)).append(",");
            }
            flr2.write(String.valueOf(stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length())));
        }
    }
}
