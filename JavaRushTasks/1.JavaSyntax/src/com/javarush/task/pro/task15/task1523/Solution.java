package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        URLConnection connection = url.openConnection();

        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        try (PrintWriter printWriter = new PrintWriter(outputStream)) {
            printWriter.print("Hello!");
        }

        InputStream inputStream = connection.getInputStream();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            while (bufferedReader.ready()) System.out.println(bufferedReader.readLine());
        }

    }
}

