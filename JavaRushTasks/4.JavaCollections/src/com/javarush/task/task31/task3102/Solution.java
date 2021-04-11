package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        MyFileWalker myFileWalker = new MyFileWalker(new ArrayList<>());
        Files.walkFileTree(Paths.get(root),EnumSet.of(FileVisitOption.FOLLOW_LINKS),Integer.MAX_VALUE,myFileWalker);
        return myFileWalker.getLinesOfFiles();

    }

    public static class MyFileWalker extends SimpleFileVisitor<Path>{
        private ArrayList<String> linesOfFiles;

        public ArrayList<String> getLinesOfFiles() {
            return linesOfFiles;
        }

        public MyFileWalker(ArrayList<String> linesOfFiles) {
            this.linesOfFiles = linesOfFiles;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if(file.toFile().isFile())linesOfFiles.add(file.toFile().getAbsolutePath());
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) {

    }
}
