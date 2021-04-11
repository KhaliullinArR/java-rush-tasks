package com.javarush.task.task17.task1711.dataBaseCommands;

import com.javarush.task.task17.task1711.Person;
import com.javarush.task.task17.task1711.Sex;
import com.javarush.task.task17.task1711.Solution;

import java.text.ParseException;
import java.util.Date;

class Update extends Command{

    private final String[] args;
    /* private int id;
     private String name;
     private Sex sex;
     private Date bd;*/

     Update(String[] args) {
         this.args = args;
        /*id = Integer.parseInt(args[1]);
        name = args[2];
        sex =  args[3].equals("м")?Sex.MALE:Sex.FEMALE;
        bd = dateFormatFromArg.parse(args[4]);*/
     }

     @Override
     public void doOperation() {
         for (int i = 1; i < args.length-1; i+=4) {
             Person update = Solution.allPeople.get(Integer.parseInt(args[i]));
             update.setSex(args[i+2].equals("м")?Sex.MALE:Sex.FEMALE);
             update.setName(args[i+1]);
             try {
                 update.setBirthDate(dateFormatFromArg.parse(args[i+3]));
             } catch (ParseException e) {
                 e.printStackTrace();
             }
         }
     }
 }
