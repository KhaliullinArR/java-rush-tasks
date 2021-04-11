package com.javarush.task.task17.task1711.dataBaseCommands;

import com.javarush.task.task17.task1711.Person;
import com.javarush.task.task17.task1711.Sex;
import com.javarush.task.task17.task1711.Solution;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

 class Create extends Command{
    private ArrayList<Person> persons = new ArrayList<>();

    Create(String[] args) throws ParseException {

        for (int i = 1; i < args.length-1; i+=3) {
            if(args[i+1].equals("м"))persons.add(Person.createMale(args[i],dateFormatFromArg.parse(args[i+2])));
            else persons.add(Person.createFemale(args[i],dateFormatFromArg.parse(args[i+2])));
        }

    }

    @Override
    public void doOperation() {

        for (Person person : persons) {
            Solution.allPeople.add(person);
            System.out.println(Solution.allPeople.size()-1);
        }


    /*  if(sex==Sex.MALE)Solution.allPeople.add(Person.createMale(name,bd));
      else Solution.allPeople.add(Person.createFemale(name,bd));
       System.out.println(Solution.allPeople.size()-1);*/
    }
 }
