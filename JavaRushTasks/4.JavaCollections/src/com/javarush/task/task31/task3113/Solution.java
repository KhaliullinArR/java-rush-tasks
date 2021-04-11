package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {



    public static class MyFileWalker extends SimpleFileVisitor<Path>{
        static long  size = 0;
        static int dirsCounts=0;
        static int filesCounts=0;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            dirsCounts++;
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            filesCounts++;
            size += Files.size(file);
            return super.visitFile(file, attrs);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(bfr.readLine());
        if(Files.isDirectory(path)){
            Files.walkFileTree(path, EnumSet.of(FileVisitOption.FOLLOW_LINKS),Integer.MAX_VALUE,new MyFileWalker());
            System.out.println("Всего папок - "+ (MyFileWalker.dirsCounts-1));
            System.out.println("Всего файлов - "+ MyFileWalker.filesCounts);
            System.out.println("Общий размер - "+ MyFileWalker.size);
            "dsa".equals(null);
          /*  Всего папок - [количество папок в директории и поддиректориях]
            Всего файлов - [количество файлов в директории и поддиректориях]
            Общий размер - [общее количество байт, которое хранится в директории]*/
        }else System.out.println(path.toString() + " - не папка");

    }
}
