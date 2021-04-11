package com.javarush.task.task17.task1710.dataBaseCommands;

import com.javarush.task.task17.task1710.Person;
import com.javarush.task.task17.task1710.Sex;
import com.javarush.task.task17.task1710.Solution;

import java.text.ParseException;
import java.util.Date;

class Update extends Command {
     private int id;
     private String name;
     private Sex sex;
     private Date bd;

     Update(String[] args) throws ParseException {
        id = Integer.parseInt(args[1]);
        name = args[2];
        sex =  args[3].equals("м")?Sex.MALE:Sex.FEMALE;
        bd = dateFormatFromArg.parse(args[4]);
     }

     @Override
     public void doOperation() {
         Person update = Solution.allPeople.get(id);
         update.setSex(sex);
         update.setName(name);
         update.setBirthDate(bd);
     }
 }
