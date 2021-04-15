package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String>  implements Cloneable, Serializable{

    Entry<String> root;

    private static Entry<String> parent;

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


    private void updateTree(Queue<Entry<String>> relatives){
        int size = relatives.size();
        if(relatives.isEmpty())return;
        for (int i = 0; i < size; i++) {
            Entry<String> parent = relatives.remove();
            if(parent.rightChild == null) parent.availableToAddRightChildren = true;
            else relatives.add(parent.rightChild);

            if(parent.leftChild == null) parent.availableToAddLeftChildren = true;
            else relatives.add(parent.leftChild);

        }
        updateTree(relatives);
    }

    private void addEntry(Queue<Entry<String>> relatives, String name) {
        int size = relatives.size();
        if(relatives.isEmpty()){
            updateTree(Stream.of(root).collect(Collectors.toCollection(LinkedList::new)));
            addEntry(Stream.of(root).collect(Collectors.toCollection(LinkedList::new)),name);
            return;
        }
        for (int i = 0; i < size; i++) {
            Entry<String> parent = relatives.remove();
            if(parent.rightChild==null && parent.availableToAddRightChildren){
                parent.rightChild=new Entry<>(name);
                parent.rightChild.parent = parent;
                return;
            }

            if(parent.leftChild==null && parent.availableToAddLeftChildren){
                parent.leftChild=new Entry<>(name);
                parent.leftChild.parent = parent;
                return;
            }

            if(parent.rightChild!=null)
            relatives.add(parent.rightChild);
            if(parent.leftChild!=null)
            relatives.add(parent.leftChild);
        }
        addEntry(relatives, name);
    }

    public void removeRec(Queue<Entry<String>> relatives, String name) {
        int size = relatives.size();
        for (int i = 0; i < size; i++) {
            Entry<String> parent = relatives.remove();
            if(parent.rightChild != null)
                if(parent.rightChild.elementName.equals(name)){
                    parent.rightChild = null;
                    parent.availableToAddRightChildren = false;
                    return;
                }
            if(parent.leftChild != null)
                if (parent.leftChild.elementName.equals(name)) {
                    parent.leftChild = null;
                    parent.availableToAddLeftChildren = false;
                    return;
                }
                relatives.add(parent.rightChild);
                relatives.add(parent.leftChild);
        }
        removeRec(relatives, name);
    }

    @Override
    public boolean remove(Object name){
        if(!(name instanceof String)) throw new UnsupportedOperationException();
        removeRec(Stream.of(root).collect(Collectors.toCollection(LinkedList::new)),(String) name);
        return true;
    }

    @Override
    public boolean add(String s) {
       addEntry(Stream.of(root).collect(Collectors.toCollection(LinkedList::new)),s);
       return true;
    }



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



    private int treeSize(Entry<String> root){
        if(root == null) return 0;
        else return treeSize(root.rightChild) + 1 + treeSize(root.leftChild);
    }

    @Override
    public int size() {
        return treeSize(root)-1;
    }

    private void findParent(String name, Queue<Entry<String>> relatives) {
        int size = relatives.size();
        if (relatives.isEmpty())return;
        for (int i = 0; i < size; i++) {
            Entry<String> par = relatives.remove();
            if(par.rightChild!=null){
               if(par.rightChild.elementName.equals(name)) {
                   parent = par;
                   return;
               }
            }

            if(par.leftChild!=null){
                if(par.leftChild.elementName.equals(name)) {
                    parent = par;
                    return;
                }
            }

            if(par.rightChild!=null)
                relatives.add(par.rightChild);
            if(par.leftChild!=null)
                relatives.add(par.leftChild);
        }
        findParent(name, relatives);
    }

    public String getParent(String name){
         if(name.equals("root"))return null;
        parent = null;
        findParent(name, Stream.of(root).collect(Collectors.toCollection(LinkedList::new)));
        if(parent == null) return null;
        return parent.elementName;
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
        else System.out.println("Do not have any child.\n");
    }
}



