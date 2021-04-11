package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader flr1 = new BufferedReader(new FileReader(args[0]));
             FileWriter flr2 = new FileWriter(args[1])) {
            flr1.lines().flatMap(line-> Stream.of(line.split(" "))).forEach(x->{
                if(Pattern.compile("\\d").matcher(x).find()) {
                    try {
                        flr2.write(x+" ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
