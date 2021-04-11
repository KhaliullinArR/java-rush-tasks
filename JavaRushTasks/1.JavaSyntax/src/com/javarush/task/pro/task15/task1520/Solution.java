package com.javarush.task.pro.task15.task1520;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Перемещение файлов
*/

public class Solution {

    public static Path sourceDirectory;
    public static Path targetDirectory;

    public static void move(DirectoryStream<Path> directoryStream) throws IOException {
        for (Path path : directoryStream) {
            if (Files.isRegularFile(path)) Files.move(path,Path.of(targetDirectory.toString()+"\\" + path.getFileName()));
            else if(Files.isDirectory(path)) move(Files.newDirectoryStream(path));
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        Solution.sourceDirectory = sourceDirectory;
        Solution.targetDirectory = targetDirectory;
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDirectory)) {
            move(directoryStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

