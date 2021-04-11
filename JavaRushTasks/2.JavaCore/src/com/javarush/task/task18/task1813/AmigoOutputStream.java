package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream wrapee;

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }


    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        wrapee = fileOutputStream;

    }

    @Override
    public void flush() throws IOException {
        wrapee.flush();
    }

    @Override
    public void write(int b) throws IOException {
        wrapee.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        wrapee.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        wrapee.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        wrapee.flush();
        wrapee.write("JavaRush © All rights reserved.".getBytes(StandardCharsets.UTF_8));
        wrapee.close();
    }

    @Override
    public FileChannel getChannel() {
        return wrapee.getChannel();
    }
}
