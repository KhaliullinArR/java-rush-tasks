package com.javarush.task.task17.task1711;



import com.javarush.task.task17.task1711.dataBaseCommands.Command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        DataManage dataManage;
        Command command;
        switch (args[0]){}
        String arg = args[0];
        if(arg.equals("-c")){
            dataManage = DataManage.CREATE;
        }else if(arg.equals("-u")){
            dataManage = DataManage.UPDATE;
        }else if(arg.equals("-i")){
            dataManage = DataManage.INFO;
        }else if(arg.equals("-d")){
            dataManage = DataManage.DELETE;
        }else dataManage= null;
        command=Command.of(args,dataManage);

        command.doOperation();

       /* for (Person allPerson : allPeople) {
            System.out.println(allPerson.getName()+" "+allPerson.getSex()+" "+Command.fromDataBasetoOutput.format(allPerson.getBirthDate()));
        }*/
    }
}
