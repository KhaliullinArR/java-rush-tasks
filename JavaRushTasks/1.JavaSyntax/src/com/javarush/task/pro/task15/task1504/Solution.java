package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* 
Перепутанные байты
*/

public class Solution {


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             InputStream fileInputStream = Files.newInputStream(Path.of(scanner.nextLine()));
             OutputStream fileOutputStream = Files.newOutputStream(Path.of(scanner.nextLine()))) {
                while (fileInputStream.available() > 0){
                    byte[] bytes = fileInputStream.readAllBytes();
                    byte temp;


                        for (int i = 0; i < bytes.length; i+=2) {
                            try {

                                
                                if (bytes[i] == 13) {
                                    continue;
                                }
                                if (bytes[i + 1] == 13) {
                                    i = i + 1;
                                    continue;
                                }

                                temp = bytes[i + 1];
                                bytes[i + 1] = bytes[i];
                                bytes[i] = temp;

                            } catch (Exception ignored) {
                            }
                        }


                    fileOutputStream.write(bytes);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
/*D:\Важное\IDEA_Project\JavaRushTasks\1.JavaSyntax\src\com\javarush\task\pro\task15\task1504\output
D:\Важное\IDEA_Project\JavaRushTasks\1.JavaSyntax\src\com\javarush\task\pro\task15\task1504\input*/
