package com.javarush.task.task20.task2022;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private String fileName;
    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }


    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
       out.defaultWriteObject();
       //out.close();
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        stream = new FileOutputStream(fileName,true);
        in.defaultReadObject();
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("D:\\Projects\\IDEA_PROJECTS\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2021\\file.txt");
        solution.writeObject("1234567889");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
        objectOutputStream.writeObject(solution);

        objectOutputStream.close();


        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(bais);

        Solution solution1 = (Solution) objectInputStream.readObject();
        objectInputStream.close();
        solution1.writeObject("1234");

        //Files.lines(Path.of("D:\\Projects\\IDEA_PROJECTS\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2021\\file.txt")).forEach(System.out::println);


    }
}
