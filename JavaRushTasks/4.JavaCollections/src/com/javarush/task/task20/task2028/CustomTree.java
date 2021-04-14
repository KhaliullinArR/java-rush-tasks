package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String>  implements Cloneable, Serializable{

    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("root");
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }




    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }



    private void addEntry(Entry<String> root, String name) {

    }

    @Override
    public boolean add(String s) {
       addEntry(root,s);

       return true;
    }

    /*public String get(int index)
    public String set(int index, String element)
    public void add(int index, String element)
    public String remove(int index)
    public List<String> subList(int fromIndex, int toIndex)
    protected void removeRange(int fromIndex, int toIndex)
    public boolean addAll(int index, Collection<? extends String> c)*/


     static class Entry<T> implements Serializable{
         String elementName;
         boolean availableToAddLeftChildren, availableToAddRightChildren;
         Entry<T> parent, leftChild, rightChild;


         public Entry(String elementName) {
             this.elementName = elementName;
             availableToAddLeftChildren = true;
             availableToAddRightChildren = true;
         }
//         isAvailableToAddChildren
         public boolean isAvailableToAddChildren(){
             return availableToAddLeftChildren||availableToAddRightChildren;
         }
     }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


    private int size(Entry<String> entry,int i){
         if(entry.leftChild==null && entry.rightChild==null)return 1;

        if(entry.rightChild!=null)i += size(entry.rightChild, i);
        if(entry.leftChild!=null)i += size(entry.leftChild, i);

        return i;
    }

    @Override
    public int size() {
         int i = 1;
         if(root.rightChild!=null)i += size(root.rightChild, i);
         if(root.leftChild!=null)i += size(root.leftChild, i);
        return i;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }


    public void watch(Entry<String> root){
        System.out.println("Entry name :"+root.elementName);
        if(root.rightChild != null && root.leftChild!=null) {
            System.out.println("Entry rightChild :" + root.rightChild.elementName);
            System.out.println("Entry leftChild :" + root.leftChild.elementName);
            System.out.println();
            watch(root.rightChild);
            watch(root.leftChild);
        }else  if(root.rightChild != null){
            System.out.println("Entry rightChild :" + root.rightChild.elementName);
            System.out.println();
            watch(root.rightChild);
        }else if(root.leftChild != null){
            System.out.println("Entry leftChild :" + root.leftChild.elementName);
            System.out.println();
            watch(root.leftChild);
        }
        System.out.println();
    }
}



