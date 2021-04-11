package com.javarush.task.pro.task14.task1415;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* 
Стек в домашних условиях
*/

public class MyStack {

    private final List<String> storage = new ArrayList<>();

 /*   public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("3");
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack);
    }*/

    public void push(String s) {
        storage.add(0,s);
    }

    public String pop() {
        return storage.remove(0);
    }

    public String peek() {
        return storage.get(0);
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public int search(String s) {
       return 0;
    }
/*
    @Override
    public String toString() {
        return storage.toString();
    }*
 */

}
