package com.javarush.task.task17.task1710.dataBaseCommands;

import com.javarush.task.task17.task1710.Person;
import com.javarush.task.task17.task1710.Sex;
import com.javarush.task.task17.task1710.Solution;

import java.text.ParseException;
import java.util.Date;

class Create extends Command {
   private String name;
   private Sex sex;
   private Date bd;

   Create(String[] args) throws ParseException {
      name = args[1];
      sex = args[2].equals("м")?Sex.MALE:Sex.FEMALE;
      bd = dateFormatFromArg.parse(args[3]);
   }

   @Override
   public void doOperation() {
     if(sex==Sex.MALE)Solution.allPeople.add(Person.createMale(name,bd));
     else Solution.allPeople.add(Person.createFemale(name,bd));
      System.out.println(Solution.allPeople.size()-1);
   }
}
