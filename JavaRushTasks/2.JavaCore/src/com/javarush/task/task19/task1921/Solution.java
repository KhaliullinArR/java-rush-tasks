package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try(BufferedReader flr = new BufferedReader(new FileReader(args[0]));){
            flr.lines().forEach(x->{
                Pattern pattern = Pattern.compile("\\d");
                Matcher matcher = pattern.matcher(x);
                matcher.find();
                int position = matcher.start();
                Person person = new Person(x.substring(0,position-1), new SimpleDateFormat("d M yyyy").parse(x,new ParsePosition(position)));
                PEOPLE.add(person);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
//        PEOPLE.forEach(x-> System.out.println(x.getName()+" "+x.getBirthDate()));
    }
}
