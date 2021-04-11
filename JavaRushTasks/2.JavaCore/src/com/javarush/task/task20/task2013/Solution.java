package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;



        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = (int)in.readObject();
            children = (List<Person>) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        Person initialPerson = new Solution.Person("Максим", "Ли", 78);
        Solution.Person father = new Solution.Person("папа", "Л1и", 99);
        Solution.Person mother = new Solution.Person("мама", "Л2и", 99);
        Solution.Person kid1 = new Solution.Person("kid1", "ki123d1", 50);
        Solution.Person kid2 = new Solution.Person("kid2", "ki123d2", 10);
        List kids = new ArrayList<>();
        kids.add(kid1);
        kids.add(kid2);
        initialPerson.setFather(father);
        initialPerson.setMother(mother);
        initialPerson.setChildren(kids);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(initialPerson);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Person loadedPerson = (Solution.Person) objectInputStream.readObject();
    }
}
