package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

public class Solution {



    public static void addFiles(File files, Map<String, File> treeMap) {
        try {
            for (File file : Objects.requireNonNull(files.listFiles())) {
                if(!file.isDirectory()){
                    if(file.length()<= 50)treeMap.put(file.getName(),file);
                }else addFiles(file, treeMap);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        TreeMap<String, File> treeMap = new TreeMap<>(String::compareTo);

        File dest = new File(resultFileAbsolutePath.getParentFile() + "/allFilesContent.txt");
        if (FileUtils.isExist(dest)) {
            FileUtils.deleteFile(dest);
        }
        FileUtils.renameFile(resultFileAbsolutePath, dest);


        FileOutputStream fileOutputStream = new FileOutputStream(dest);

        addFiles(path, treeMap);

        treeMap.forEach((k, v)->{

            try {
                fileOutputStream.write(Files.readAllBytes(v.toPath()));
                fileOutputStream.write("\n".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


        fileOutputStream.close();
    }
}
