package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream wrapee;

    public QuestionFileOutputStream(AmigoOutputStream wrapee) {
        this.wrapee = wrapee;
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
        wrapee.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String answer = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if(answer.equals("Д"))wrapee.close();
    }
}

