package com.javarush.task.task20.task2014;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable{
    public static void main(String[] args) throws IOException {
        Path file = Files.createTempFile("tempfile",null);
        FileInputStream fileInputStream = new FileInputStream(file.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file.toString());
        Solution savedObject = new Solution(10);
        Solution loadedObject = new Solution(112);

        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        oos.writeObject(savedObject);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        try {
            loadedObject = (Solution) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
