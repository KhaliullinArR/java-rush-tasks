package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/hgjkjhkhkhk/bin/foiksoi/fdsfisfs/skfs";//

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        int index1 = path.indexOf("/")+1;
        for (int i = 0; i < 2; i++) {
            index1 = path.indexOf("/", index1+1);
        }
        int index2 = path.indexOf("/", index1+1);
        return path.substring(0,index1+1) + jdk + path.substring(index2) ;
    }
}
