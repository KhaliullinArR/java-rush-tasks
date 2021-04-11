package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Поверхностное копирование
*/

public class Solution {

    public static Path sourceDirectory;
    public static Path targetDirectory;

    public static void copy(DirectoryStream<Path> directoryStream) throws IOException {
        for (Path path : directoryStream) {
            if (Files.isRegularFile(path)) Files.copy(path,Path.of(targetDirectory.toString()+"\\" + path.getFileName()));
            else if(Files.isDirectory(path)) copy(Files.newDirectoryStream(path));
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        Solution.targetDirectory = targetDirectory;
        Solution.sourceDirectory = sourceDirectory;
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDirectory)) {
            copy(directoryStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

